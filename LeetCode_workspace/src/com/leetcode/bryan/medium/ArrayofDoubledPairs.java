package com.leetcode.bryan.medium;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3877/
 *
 * 本題目是說給定一個int array, 是否可以符合兩兩數組, 使得其中一個為另一個的2倍
 *
 *  解法是把所有的數分為2群, 各別存在一個hash map裏, 一群存負數, 一群存正數, 分開check, 因為一定是正數跟正數配, 負數跟負數配
 *
 * Time : O(NlogN)
 */

public class ArrayofDoubledPairs {
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> mapPos = new HashMap<>();
        HashMap<Integer, Integer> mapNeg = new HashMap<>();
        HashMap<Integer, Integer> pointer;

        int len = arr.length;

        for (int i = 0; i < len; i++) {
            if (arr[i] > 0) pointer = mapPos;     // <-- 把array裏每個數分開存在不同的hash map裏, 依其是正數or負數
            else pointer = mapNeg;

            int value = pointer.getOrDefault(arr[i], 0);
            value++;
            pointer.put(arr[i], value);
        }

        Arrays.sort(arr);   // <-- sort這步是重點, sort過後下面的code才有意義

        for (int key : arr) {
            if (key > 0) pointer = mapPos;      // 正數在正數的hash map裏check, 負數在負數的hash map裏check
            else pointer = mapNeg;

            int value = pointer.get(key);   // <-- 這裏開始一個一個check, 若該正數存在的話, 那下面的check一定要存在它的2倍數. 但該正數有可能不存在map裏, 因為已經被前面check時用掉了
            if (value > 0) {
                value--;
                pointer.put(key, value);
            } else {
                continue;   // <-- 不存在map裏, 有可能已經被前面check時用掉了, 不一定是有問題, 先continue做下去
            }

            int newKey;
            if (key > 0) newKey = key * 2;          // <-- 這裏開始check 2倍數是否存在, 跟上面不一樣, 不存在hash map裏就是有問題, 直接return
            else newKey = key / 2;

            int value_x2 = pointer.getOrDefault(newKey, -1);
            if (value_x2 <= 0) return false;

            if (value_x2 > 0) {
                value_x2--;
                pointer.put(newKey, value_x2);
            }
        }

        for (int key : mapPos.keySet()) {       // <-- 最後檢查hash map裏, 若每個value都是0, 表示全部有配對到, 符合
            int value = mapPos.get(key);

            if (value > 0) return false;
        }

        for (int key : mapNeg.keySet()) {   // <-- 負數也檢查
            int value = mapNeg.get(key);

            if (value > 0) return false;
        }

        return true;
    }
}

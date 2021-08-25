package com.leetcode.bryan.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3891/
 *
 * 這題的解法已經有match到leetcode裏的solution, 就是先由字串頭開始, 找到一第一個滿足的substring, 此時給定2個pointer, 一左一右, 左指向此
 * substring的開頭, 右指定在結尾
 *
 * 接著開始先移動左pointer, 直到使新的substring不滿足條件為止. 然後一樣再移動右pointer, 直到使新的substring又滿足條件為止
 * 如此一直重覆, 直接右pointer到原字串底為止. 並在每個substring滿足時比對當下的length, 記下最小值
 *
 * 目前下面的code會TLE, 要再tune一下, match的function要再化簡一下.
 *
 */

class matchChar {
    public int index;
    public char ch;

    public matchChar(int i, char c) {
        index = i;
        ch = c;
    }
}

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> set = new HashMap<>();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int minWindowsSize = Integer.MAX_VALUE;
        String minWindowString = "";

    // 1. put the chars of string t into hash set
        char[] arr_t = t.toCharArray();
        for (char c : arr_t) {
            int value = set.getOrDefault(c, 0);
            value++;
            set.put(c, value);
        }

    // 2. put matched chars of string s into list
        List<matchChar> list = new ArrayList<>();
        char[] arr_s = s.toCharArray();
        int len = s.length();

        for (int i = 0; i < len; i++)
            if (set.containsKey(arr_s[i])) list.add(new matchChar(i, arr_s[i]));

        for (int k = t.length(); k < list.size(); k++) {
            if (matchWindowString(0, k, list, set)) {
                minWindowsSize = k + 1;
                minWindowString = s.substring(0, k + 1);
            }
        }

        int i = 0, j = 0;       // <-- TODO : 這邊還沒優化, 要從第一個matched的substring開始, 所以i, j可能不為0
        while (j < list.size()) {
            while (matchWindowString(i, j, list, set)) {
                int curMin = list.get(j).index - list.get(i).index + 1;
                if (minWindowsSize > curMin) {
                    minWindowsSize = curMin;
                    minWindowString = s.substring(list.get(i).index, list.get(j).index + 1);
                }

                i++;
            }

            j++;
        }

        return minWindowString;
    }

    private boolean matchWindowString(int start, int end, List<matchChar> list, HashMap<Character, Integer> set) {
        HashMap<Character, Integer> dummy = new HashMap<>(set);

        for (int l = start; l <= Math.min(end, list.size()); l++) {
            char c = list.get(l).ch;

            if (dummy.containsKey(c)) {
                int value = dummy.get(c);
                if (value > 0) {
                    value--;
                    dummy.put(c, value);

                    if (value == 0) dummy.remove(c);
                }
            }
        }

        boolean rlt = (dummy.size() == 0) ? true : false;
        return rlt;
    }
}

package com.leetcode.bryan.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/largest-number/
 *
 * 精神上把愈大的element排前面, 組合成的數就會愈大, 所以也就是要sort, sort完後, 就可以知道哪個element大
 * 比較的部份, 要自行實作Comparator. 邏輯舉例來說, 3和9, 因為位數一樣, 所以直接比, 也就是9 > 3
 * 若位數不一樣時, 則必需先把2數串起來後, 再一位一位的比. 這部份可以再看一下有沒有辦法簡單化一些
 * 注意compare()實作那邊因為是要由大排到小, 所以要return b-a而不是a-b的結果
 *
 * Time : O(nkLog(nk)) <---- ??
 */

public class LargestNumber {
    class intObj {
        intObj(int val) {
            value = val;
        }

        int value;
    }

    private int nums[] = {999999991, 9};

    private int LengthNum(int num) {
        int count = 0;

        while (num >= 1) {
            num /= 10;
            count++;
        }

        return count;
    }

    public String largestNumber() {
        intObj obj[] = new intObj[nums.length];

        for (int i = 0; i < nums.length; i++) obj[i] = new intObj(nums[i]);

        Arrays.sort(obj, new Comparator<intObj>() {
            @Override
            public int compare(intObj a, intObj b) {
                if (LengthNum(a.value) == LengthNum(b.value)) return b.value - a.value;
                else {
                    String v1 = String.valueOf(a.value);
                    String v2 = String.valueOf(b.value);

                    String s1 = v1 + v2;
                    String s2 = v2 + v1;

                    char[] c1 = s1.toCharArray();
                    char[] c2 = s2.toCharArray();

                    for (int i = 0; i < c1.length; i++) {
                        int  diff = c2[i] - c1[i];
                        if (diff == 0) continue;
                        return diff;
                    }

                    return 0;
                }
            }
        });

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");

        String result = "";

        for (int i = 0; i < nums.length; i++) result += String.valueOf(obj[i].value);
        return result;
    }
}

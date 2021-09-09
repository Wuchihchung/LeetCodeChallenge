package com.leetcode.bryan.medium;


/**
 * https://leetcode.com/problems/shifting-letters/solution/
 */

public class ShiftingLetters {
    public String shiftingLetters(String s, int[] shifts) {
        shifts[shifts.length - 1] %= 26;

        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] += shifts[i + 1];
            shifts[i] %= 26;
        }

        char[] ret = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = ret[i];
            c += shifts[i];

            if (c > 0x7A) c -= 0x1A;

            ret[i] = c;
        }

        return new String(ret);
    }
}

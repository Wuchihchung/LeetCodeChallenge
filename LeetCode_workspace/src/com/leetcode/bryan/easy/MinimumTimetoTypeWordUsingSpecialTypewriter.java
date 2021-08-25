package com.leetcode.bryan.easy;

import java.util.Locale;

/**
 * https://leetcode.com/contest/biweekly-contest-59/problems/minimum-time-to-type-word-using-special-typewriter/
 *
 *
 */

public class MinimumTimetoTypeWordUsingSpecialTypewriter {
    public int minTimeToType(String word) {
        int count = 0;
        char curIndex = 'a';

        char[] words = word.toCharArray();

        for (char c : words) {
            int diff1 = Math.abs((int)(c - curIndex));
            int diff2 = 26 - diff1;
            curIndex = c;

            count += Math.min(diff1, diff2);
            count++;
        }

        return count;
    }
}

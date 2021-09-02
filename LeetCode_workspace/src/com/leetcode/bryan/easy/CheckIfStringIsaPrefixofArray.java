package com.leetcode.bryan.easy;


/**
 * https://leetcode.com/contest/weekly-contest-253/problems/check-if-string-is-a-prefix-of-array/
 *
 * 解法直接直覺解即可
 *
 * Time : O(M), M是stirng s可被拆解成的substring個數
 */

public class CheckIfStringIsaPrefixofArray {
    public boolean isPrefixString(String s, String[] words) {
        for (String word : words) {
            if (s.indexOf(word) == 0) {
                s = s.substring(word.length());

                if (s.isEmpty()) return true;
            } else {
                return false;
            }
        }

        return false;
    }
}
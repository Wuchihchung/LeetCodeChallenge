package com.leetcode.bryan.medium;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/solution/
 *
 * 1. 用從中心往外炸列開判斷比較直接, dynamic programming的方式較不易懂
 * 2. 下面sample code寫的很精簡, 可以再看看
 *
 * Time : O(n)
 */

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {            // <--- 精簡
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;

        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }

        return R - L - 1;
    }
}
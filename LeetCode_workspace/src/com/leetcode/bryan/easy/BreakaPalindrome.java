package com.leetcode.bryan.easy;


/**
 * https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3985/
 */

public class BreakaPalindrome {
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        int left = 0, right = len - 1;
        int mid = len / 2;

        if (len == 1) return "";
        char[] sBreak = palindrome.toCharArray();

        int index = 0;
        while (index < mid) {
            if (sBreak[index] > 'a') {
                sBreak[index] = 'a';
                return new String(sBreak);
            }

            index++;
        }

        if (len % 2 == 0) mid -= 1;
        index = mid + 1;
        while (index < len - 1 ) {
            if (sBreak[index] > 'a') {
                sBreak[index] = 'a';
                return new String(sBreak);
            }

            index++;
        }

        sBreak[len - 1] = 'b';
        return new String(sBreak);
    }
}
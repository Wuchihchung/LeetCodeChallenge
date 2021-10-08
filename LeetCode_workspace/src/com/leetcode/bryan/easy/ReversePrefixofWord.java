package com.leetcode.bryan.easy;


/**
 * https://leetcode.com/contest/weekly-contest-258/problems/reverse-prefix-of-word/
 */

public class ReversePrefixofWord {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) return word;

        String rest = word.substring(index + 1);
        char[] arr = new char[index + 1];
        int x = 0;
        for (int i = index; i >= 0; i--) {
            arr[x] = word.charAt(i);
            x++;
        }

        return new String(arr) + rest;
    }
}
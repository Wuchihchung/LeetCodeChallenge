package com.leetcode.bryan.easy;


/**
 * https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3974/
 */

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        int len = s.length();
        char[] newString = s.toCharArray();
        char[] arr = s.toCharArray();

        int index = len - 1;
        for (int i = 0; i < len; i++) {
            if (Character.isAlphabetic(arr[i])) {
                while (!Character.isAlphabetic(newString[index])) {
                    index--;
                }

                newString[index] = arr[i];
                index--;
            }
        }

        return new String(newString);
    }
}
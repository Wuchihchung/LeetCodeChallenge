package com.leetcode.bryan.easy;


/**
 *
 */

public class MinimumMovestoConvertString {
    public int minimumMoves(String s) {
        char[] arr = s.toCharArray();
        int index = 0;
        int count = 0;

        while (index < arr.length) {
            if (arr[index] == 'O') {
                index++;
                continue;
            }

            if (arr[index] == 'X') {
                count++;

                if (index >= arr.length - 3) break;

                index += 3;
            }
        }

        return count;
    }
}

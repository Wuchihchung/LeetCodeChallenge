package com.leetcode.bryan.easy;


/**
 * https://leetcode.com/problems/convert-1d-array-into-2d-array/
 *
 * Time : O(n)
 */

public class Convert1DArrayInto2DArray {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        int[][] result = {};
        if (m * n != len) return result;

        result = new int[m][n];
        int x = 0, y;
        for (int i = 0; i < len; i += n) {
            y = 0;

            for (int j = i; j < i + n; j++) {
                result[x][y] = original[j];
                y++;
            }

            x++;
        }

        return result;
    }
}
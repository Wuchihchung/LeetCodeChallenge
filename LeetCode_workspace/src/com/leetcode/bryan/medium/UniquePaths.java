package com.leetcode.bryan.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-paths/
 *
 * 1. 方法一是用dynamic programming, 精神是目前這格可以到達的方式為由上一格走下來or從左一格走過來
 *    所以走法就是這2格的走法相加總
 * 2. 方法二是直接用排列組合的算法 => (m+n-2)!/(m-1)!(n-1)!
 *
 * Time : O(mxn)
 */

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] d = new int[m][n];

        for (int[] arr : d) {
            Arrays.fill(arr, 1);
        }

        for (int col = 1; col < m; ++col) {
            for (int row = 1; row < n; ++row) {
                d[col][row] = d[col - 1][row] + d[col][row - 1];
            }
        }

        return d[m - 1][n - 1];
    }
}

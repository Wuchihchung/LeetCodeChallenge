package com.leetcode.bryan.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3888/
 *
 * 這題的解法是先走過整個2維陣列一次, 把造成0的row or column全部記錄下來
 * 接著再照著記錄回頭把原始array對應的row, column全部填0
 *
 * Time : O(MN)
 */

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();

        int m = matrix.length;
        int n = matrix[0].length;
        boolean done = false;

        for (int i = 0; i < m && !done ; i++) {
            for (int j = 0; j < n && !done; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    column.add(j);

                    if (row.size() == m && column.size() == n) done = true;
                }
            }
        }

        Iterator<Integer> keyRow = row.iterator();
        while (keyRow.hasNext()) {
            Arrays.fill(matrix[keyRow.next()], 0);
        }

        Iterator<Integer> keyCol = column.iterator();
        while (keyCol.hasNext()) {
            int index = keyCol.next();
            for (int i = 0; i < m; i++) matrix[i][index] = 0;
        }

        System.out.println("FDFDFDFDFD");
    }
}

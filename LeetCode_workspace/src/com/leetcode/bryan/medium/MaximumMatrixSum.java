package com.leetcode.bryan.medium;

public class MaximumMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        int maxMinus = Integer.MAX_VALUE;
        int count = 0;
        int total = 0;
        boolean zeroExist = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int val = matrix[i][j];
                if (val == 0) zeroExist = true;

                maxMinus = Math.min(maxMinus, Math.abs(val));

                if (val < 0) {
                    count++;
                    total += val * (-1);
                } else {
                    total += val;
                }
            }
        }

        System.out.println(total);
        System.out.println(count);
        System.out.println(maxMinus);

        if (zeroExist) return total;

        if (count % 2 == 0) {
            return total;
        } else {
            return  total - maxMinus - maxMinus;
        }
    }
}

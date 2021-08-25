package com.leetcode.bryan.medium;

public class MinimizetheDifferenceBetweenTargetandChosenElements {
    public int minimizeTheDifference(int[][] mat, int target) {
        int column = mat.length;

        int minValue = getMinDiffValue(mat, 0, column - 1, target);
        return minValue;
    }

    private int getMinDiffValue(int[][] mat, int start, int end, int target) {
        if (start == end) {
            int minDiff = Integer.MAX_VALUE;

            for (int val : mat[end]) {
                if (val == target) return 0;
                else {
                    minDiff = Math.min(minDiff, Math.abs(target - val));
                }
            }

            return minDiff;
        }

        int min = Integer.MAX_VALUE;

        for (int val : mat[start]) {
            if (val < target) {
                int curMin = getMinDiffValue(mat, start + 1, end, target - val);
                min = Math.min(min, curMin);
            }
        }

        return min;
    }
}

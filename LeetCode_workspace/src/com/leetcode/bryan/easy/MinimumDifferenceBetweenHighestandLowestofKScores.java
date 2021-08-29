package com.leetcode.bryan.easy;

import java.util.Arrays;


public class MinimumDifferenceBetweenHighestandLowestofKScores {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (i + k - 1 < nums.length) {
                int cur = nums[i + k - 1] - nums[i];
                min = Math.min(min, cur);
            } else break;
        }

        return min;
    }
}
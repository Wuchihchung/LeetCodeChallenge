package com.leetcode.bryan.medium;



public class SumofBeautyintheArray {
    public int sumOfBeauties(int[] nums) {
        int maxLeft = nums[0];
        int minRight = nums[nums.length - 1];
        int sum = 0;
        int[] beautyLeft = new int[nums.length];

        for (int i = 1; i <= nums.length - 2; i++) {
            if (nums[i] > maxLeft) beautyLeft[i] = 2;
            else if (nums[i] > nums[i - 1]) beautyLeft[i] = 1;

            maxLeft = Math.max(maxLeft, nums[i]);
        }

        for (int i = nums.length - 2; i >= 1; i--) {
            int currRight = 0;
            if (nums[i] < minRight) currRight = 2;
            else if (nums[i] < nums[i + 1]) currRight = 1;

            minRight = Math.min(minRight, nums[i]);
            sum += Math.min(currRight, beautyLeft[i]);
        }

        return sum;
    }
}
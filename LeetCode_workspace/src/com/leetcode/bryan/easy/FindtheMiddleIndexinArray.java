package com.leetcode.bryan.easy;


/**
 * https://leetcode.com/contest/biweekly-contest-60/problems/find-the-middle-index-in-array/
 */

public class FindtheMiddleIndexinArray {
    public int findMiddleIndex(int[] nums) {
        int total = 0;

        for (int i = 1; i < nums.length; i++) total += nums[i];

        int left = 0, right = total;
        int index = 0;
        while (index < nums.length - 1) {
            if (left == right) return index;
            left += nums[index];
            right -= nums[index + 1];

            index++;
        }

        if (left == right) return index;
        return -1;
    }
}
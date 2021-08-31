package com.leetcode.bryan.medium;


/**
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/617/week-5-august-29th-august-31st/3958/
 *
 * Time : O(logn)
 */

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int len = nums.length;

        if (nums[0] < nums[len - 1]) return nums[0];

        int left = 0;
        int right = len - 1;
        int middle = len / 2;

        while (right - left > 1) {
            if (nums[middle] < nums[right]) right = middle;
            else left = middle;

            middle = (left + right) / 2;
        }

        return nums[right];
    }
}
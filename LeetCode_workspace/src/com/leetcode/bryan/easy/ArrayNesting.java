package com.leetcode.bryan.easy;


/**
 * https://leetcode.com/explore/featured/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3960/
 *
 * Time : O(n)
 */

public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int maxLen = 0;
        int halfLength = nums.length / 2;
        int count, next;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) continue;

            count = 0;
            next = nums[i];

            while (next != -1) {
                nums[i] = -1;
                count++;

                next = nums[next];
            } ;

            maxLen = Math.max(maxLen, count);
            if (maxLen > halfLength) return maxLen;
        }

        return maxLen;
    }
}
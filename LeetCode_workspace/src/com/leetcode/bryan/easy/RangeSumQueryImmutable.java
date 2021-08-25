package com.leetcode.bryan.easy;

/**
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3892/
 *
 * Time : O(N) at beginning and then goes to O(1)
 */

public class RangeSumQueryImmutable {
    int[] sum;

    public RangeSumQueryImmutable(int[] nums) {
        sum = new int[nums.length];

        for (int i = 1; i < nums.length; i++)
            sum[i] += sum[i - 1];
    }

    public int sumRange(int left, int right) {
        if (left == 0) return sum[right];
        else return sum[right] - sum[left];
    }
}

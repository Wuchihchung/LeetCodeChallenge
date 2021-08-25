package com.leetcode.bryan.easy;

import java.util.Arrays;

public class FindGreatestCommonDivisorofArray {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return gcdByEuclidsAlgorithm(nums[0], nums[len - 1]);
    }

    private int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }

        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }
}

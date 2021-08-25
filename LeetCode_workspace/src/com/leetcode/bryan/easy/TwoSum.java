package com.leetcode.bryan.easy;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/
 *
 */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int[] results = new int[2];

        for (int idx = 0; idx < nums.length; idx++) {
            int value = hash.getOrDefault(target - nums[idx], -1);
            if (value > -1) {
                results[0] = value;
                results[1] = idx;

                System.out.println(value + ", " + idx);
                break;
            }

            hash.put(nums[idx], idx);
        }

        return results;
    }
}

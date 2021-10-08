package com.leetcode.bryan.medium;


/**
 * https://leetcode.com/contest/biweekly-contest-62/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/
 *
 */

public class NumberofPairsofStringsWithConcatenationEqualtoTarget {
    public int numOfPairs(String[] nums, String target) {
        int count = 0;
        int len = target.length();

        for (int i = 0; i < nums.length; i++) {
            int numLen1 = nums[i].length();
            if (numLen1 >= len) continue;
            int index = target.indexOf(nums[i]);
            if ( index != 0) continue;

            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;

                int numlen2 = nums[j].length();
                String sub = target.substring(numLen1);

                if (numlen2 != sub.length()) continue;
                if (sub.equals(nums[j])) count++;
            }
        }

        return count;
    }
}
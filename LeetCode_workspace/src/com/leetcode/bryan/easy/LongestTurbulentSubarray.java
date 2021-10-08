package com.leetcode.bryan.easy;


/**
 * https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3976/
 *
 * Time : O(n)
 */

public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int diff = arr[i] - arr[i - 1];
            if (diff == 0) arr[i] = 0;
            else arr[i] = (diff > 0) ? 1 : -1;
        }

        int count = 1;
        int max = 1;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] == 0) {
                max = Math.max(count, max);
                count = 1;
                continue;
            }

            int j = i + 1;
            count = 2;
            while ((j + 1) < arr.length && (arr[j] * arr[j + 1]) < 0) {
                count++;
                j++;
            }

            max = Math.max(count, max);
            count = 1;
            i = j - 1;
        }

        return max;
    }
}
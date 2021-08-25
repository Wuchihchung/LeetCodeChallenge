package com.leetcode.bryan.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 *
 * 前提是必先sort
 * Sort完後關鍵就是必需是從最大or最小的值去消除, 才能最有效的縮減difference
 * 所以在消除3個的情況下, 就只有4種case, (最小, 最大) => (0, 3), (1, 2), (2, 1), (3, 0)
 * 所以最小difference就是從這4種去選出minimum的
 *
 * Time : Nlong(N)
 *
 */

public class MinimumDifferenceBetweenLargestandSmallestValueinThreeMoves {
    public int minDifference(int[] nums) {
        int len = nums.length;
        if (len < 5) return 0;

        Arrays.sort(nums);

        int case1 = nums[len - 1] - nums[3];
        int case2 = nums[len - 4] - nums[0];

        int case3 = nums[len - 2] - nums[2];
        int case4 = nums[len - 3] - nums[1];

        int x = Math.min(case1, case2);
        int y = Math.min(case3, case4);
        int z = Math.min(x, y);

        return z;
    }
}

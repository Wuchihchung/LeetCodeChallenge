package com.leetcode.bryan.hard;

/**
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3890/
 *
 */

public class PaintHouseII {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if (n == 0) return 0;
        int k = costs[0].length;

        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, min1_index = -1;

        for (int j = 0; j < k; j++) {
            if (costs[0][j] < min1) {
                min2 = min1;
                min1 = costs[0][j];
                min1_index = j;
            }
            else if (costs[0][j] < min2) {
                min2 = costs[0][j];
            }
        }

        for (int i = 1; i < n; i++) {
            int min1_ = Integer.MAX_VALUE, min2_ = Integer.MAX_VALUE, min1_index_ = -1;

            for (int j = 0; j < k; j++) {
                int cost = costs[i][j] + (min1_index == j ? min2 : min1);

                if (cost < min1_) {
                    min2_=min1_;
                    min1_ = cost;
                    min1_index_ = j;
                }
                else if (cost < min2_) {
                    min2_ = cost;
                }
            }

            min1 = min1_;
            min2 = min2_;
            min1_index = min1_index_;
        }

        return min1;
    }
}

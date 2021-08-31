package com.leetcode.bryan.easy;

import java.lang.reflect.Array;


/**
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/617/week-5-august-29th-august-31st/3957/
 *
 * Time : O(n), where n is the length of ops.
 */

public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {

        int minM = m;
        int minN = n;

        for (int i = 0; i < ops.length; i++) {
            if (minM != 1)  minM = Math.min(minM, ops[i][0]);
            if (minN != 1) minN = Math.min(minN, ops[i][1]);
        }

        return minM * minN;
    }
}
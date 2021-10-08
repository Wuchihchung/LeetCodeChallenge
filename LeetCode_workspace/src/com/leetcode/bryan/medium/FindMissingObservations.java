package com.leetcode.bryan.medium;

import java.util.Arrays;


/**
 * https://leetcode.com/problems/find-missing-observations/
 */

public class FindMissingObservations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int len = rolls.length + n;
        int count = 0;

        for (int roll : rolls) count += roll;

        int rest = mean * len - count;
        int[] result = {};
        if (rest < n) return result;

        int[] rollsMissing = new int[n];
        Arrays.fill(rollsMissing, 1);
        rest -= n;

        for (int r = 0; r < n; r++) {
            if (rest <= 5) {
                rollsMissing[r] += rest;
                rest = 0;
                break;
            } else {
                rest -= 5;
                rollsMissing[r] += 5;
            }
        }

        if (rest > 0) return result;
        else return rollsMissing;
    }
}
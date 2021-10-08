package com.leetcode.bryan.easy;

import java.util.HashMap;


/**
 * https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3973/
 */

public class MaximumNumberofBalloons {
    public int maxNumberOfBalloons(String text) {
        char[] arr = text.toCharArray();
        int[] count = new int[5];

        for (char c : arr) {
            switch (c) {
                case 'b':
                    count[0]++;
                    break;
                case 'a':
                    count[1]++;
                    break;
                case 'l':
                    count[2]++;
                    break;
                case 'o':
                    count[3]++;
                    break;
                case 'n':
                    count[4]++;
                    break;
                default:
                    break;
            }
        }

        count[2] /= 2;
        count[3] /= 2;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 4; i++) if (count[i] < min) min = count[i];

        return min;
    }
}

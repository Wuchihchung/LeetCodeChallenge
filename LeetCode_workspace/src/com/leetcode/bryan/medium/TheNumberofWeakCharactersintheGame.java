package com.leetcode.bryan.medium;

import java.util.Arrays;
import java.util.Comparator;


/**
 *
 */

public class TheNumberofWeakCharactersintheGame {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p1[0] == p2[0]) return p1[1] - p2[1];
                else return p1[0] - p2[0];
            }
        });

        int count = 0;
        int len = properties.length;
        int index = len - 2;
        int maxX = properties[len - 1][0];
        int maxY = properties[len - 1][1];

        while (index >= 0) {
            if (properties[index][0] == maxX) {
                if (properties[index][1] > maxY) maxY = properties[index][1];

                index--;
                continue;
            }

            break;
        }

        if (index >= 0) maxX = properties[index][0];
        int curMax = 0;

        while (index >= 0) {
            if (properties[index][0] < maxX) {
                maxX = properties[index][0];
                maxY = Math.max(maxY, curMax);
                curMax = 0;
            }

            if (properties[index][1] < maxY) count++;

            curMax = Math.max(curMax, properties[index][1]);

            index--;
        }

        return count;
    }
}
package com.leetcode.bryan.easy;

import java.util.Arrays;
import java.util.Comparator;


/**
 * https://leetcode.com/problems/maximum-units-on-a-truck/
 */

public class MaximumUnitsonaTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] b1, int[] b2) {
                return b1[1] - b2[1];
            }
        });

        int index = boxTypes.length - 1;
        int maxUnits = 0;

        while (truckSize > 0 && index >= 0) {
            if (boxTypes[index][0] <= truckSize) {
                maxUnits += boxTypes[index][1] * boxTypes[index][0];
                truckSize -= boxTypes[index][0];
                index--;
            }
            else {
                maxUnits += boxTypes[index][1] * truckSize;
                break;
            }
        }

        return maxUnits;
    }
}
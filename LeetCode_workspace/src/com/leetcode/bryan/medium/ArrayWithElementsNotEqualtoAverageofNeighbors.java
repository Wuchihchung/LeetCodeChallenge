package com.leetcode.bryan.medium;

import java.util.Arrays;

public class ArrayWithElementsNotEqualtoAverageofNeighbors {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);

        int[] newArray = new int[nums.length];
        int halfIndex = nums.length / 2;

        int j = 0;
        for (int i = nums.length - 1; i >= halfIndex; i--) {
            newArray[j * 2] = nums[i];
            j++;
        }

        j = 0;
        for (int i = halfIndex - 1; i >= 0; i--) {
            newArray[j * 2 + 1] = nums[i];
            j++;
        }

        return newArray;
    }
}

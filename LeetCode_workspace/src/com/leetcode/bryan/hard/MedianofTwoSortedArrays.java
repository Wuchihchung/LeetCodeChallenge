package com.leetcode.bryan.hard;

import java.util.Arrays;


/**
 *
 */

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int index = n;
        int left, right;

        while (true) {
            int found = Arrays.binarySearch(nums1, nums2[index / 2]);

            if (found >= 0) {
                left = found + index / 2;
                right = (n + m) - left - 1;
            }

            index /= 2;
        }
    }
}
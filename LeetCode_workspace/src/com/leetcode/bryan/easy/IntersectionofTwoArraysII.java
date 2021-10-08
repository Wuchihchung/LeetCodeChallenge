package com.leetcode.bryan.easy;

import java.util.ArrayList;
import java.util.List;


/**
 *
 */

public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] num1_new = new int[1000];
        int[] num2_new = new int[1000];

        for (int i = 0; i < nums1.length; i++) num1_new[nums1[i]] += 1;
        for (int i = 0; i < nums2.length; i++) num2_new[nums2[i]] += 1;

        int m = nums1.length;
        int n = nums2.length;
        int index = 999;
        List<Integer> list = new ArrayList<>();

        while (index >= 0) {
            if (num1_new[index] != 0) {
                int count = Math.min(num1_new[index], num2_new[index]);
                for (int i = 0; i < count; i++) list.add(index);
            }

            index--;
        }

        int[] arr = new int[list.size()];
        for (int i =0; i < list.size(); i++) arr[i] = list.get(i);

        return arr;
    }
}
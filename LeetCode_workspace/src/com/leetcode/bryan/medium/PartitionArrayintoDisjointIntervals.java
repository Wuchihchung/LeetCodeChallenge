package com.leetcode.bryan.medium;

public class PartitionArrayintoDisjointIntervals {
    public int partitionDisjoint() {
        int nums[] = {5,0,3,8,6};

        int size = nums.length;
        int left[] = new int[size];
        int right[] = new int[size];
        left[0] = nums[0];
        right[size - 1] = nums[size - 1];

        for (int i = 1; i < size; i++) {
            left[i] = Math.max(left[i - 1], nums[i]);
        }

        for (int j = size - 2; j >= 0; j--) {
            right[j] = Math.min(right[j + 1], nums[j]);
        }

        for (int i = 0; i < size - 1; i++) {
            if (left[i] < right[i + 1]) return i + 1;
        }

        return -1;
    }
}

package com.leetcode.bryan.easy;


/**
 *
 */

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) {
        int len = nums.length;
        int oddIndex = 0, evenIndex = 1;

        while (oddIndex < len && evenIndex < len) {
            boolean oddOK = ((oddIndex + nums[oddIndex]) % 2 == 0) ? true : false;
            boolean evenOK = ((evenIndex + nums[evenIndex]) % 2 == 0) ? true : false;

            if (oddOK) oddIndex += 2;
            if (evenOK) evenIndex += 2;

            if (!oddOK && !evenOK) {
                int tmp = nums[oddIndex];
                nums[oddIndex] = nums[evenIndex];
                nums[evenIndex] = tmp;

                oddIndex += 2;
                evenIndex += 2;
            }
        }

        return nums;
    }
}
package com.leetcode.bryan.medium;

/**
 * https://leetcode.com/problems/sort-colors/
 *
 * - If nums[curr] = 0 : swap currth and p0th elements and move both pointers to the right.
 * - If nums[curr] = 2 : swap currth and p2th elements. Move pointer p2 to the left.
 * - If nums[curr] = 1 : move pointer curr to the right.
 *
 * 這個演算法的精神就是P0指標代表flag 0的指標, P2指標代表flag 2的指標, current指標代表flag 1的指標
 * 當P0被換給0 or P2被換給2時, 表示P0 or P2當下指到的點已經OK, 所以可以再往下移動
 * 當current為1時, 表示current當下指的點已經OK, 所以可以再往下移動
 *
 * Time : O(n)
 */

public class SortColors {
    private static int nums[] = {2, 0, 2, 1, 1, 0};

    public static void sortColors() {
        // for all idx < i : nums[idx < i] = 0
        // j is an index of element under consideration
        int p0 = 0, curr = 0;
        // for all idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // swap p0-th and curr-th elements
                // i++ and j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }
            else if (nums[curr] == 2) {
                // swap k-th and curr-th elements
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            }
            else curr++;
        }
    }
}

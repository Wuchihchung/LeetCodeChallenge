package com.leetcode.bryan.easy;

/**
 * https://leetcode.com/problems/sign-of-the-product-of-an-array/
 *
 * 1. 當發現有0時則結束, 直接reutnr 0
 * 2. 當發現是正數時, 不用管, 因為正數不影響結果
 * 3. 當發現負數時, 則用XOR來記錄, 就是來一個負數則是負的, 來2個變正的...
 *
 * Time : O(n)
 */

public class SignoftheProductofanArray {
    public int arraySign(int[] nums) {
        int negative = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) return 0;
            if (nums[i] < 0) negative ^= 1;
        }

        return (negative == 1) ? -1 : 1;
    }
}

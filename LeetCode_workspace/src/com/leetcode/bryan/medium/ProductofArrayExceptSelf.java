package com.leetcode.bryan.medium;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * 1. 先整個array掃一遍, 若array裏含超過2個(含)以上的零, 則直接return全部為0的array, 因為怎麼乘結果都一定是0
 * 2. 承上, 掃完一遍後, 記錄array裏含有1個0 or都沒有含
 * 3. 承1, 掃完一遍後, 把每個非0的element都乘起來
 * 4. 再整個array掃一遍, 到這步時, array裏的含0數量只有0 or 1個
 *    0個 : 結果array = 總乘數/每個element
 *    1個 : 則每個結果都是0, 除了本身為0的那個element, 它的result就是總乘數
 *
 * Time : O(n)
 *
 */

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int zeroCount = 0;
        int[] result = new int[len];
        int product = 1;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zeroCount++;

                if (zeroCount >= 2) return result;

                continue;
            }

            product *= nums[i];
        }

        for (int i = 0; i < len; i++) {
            if (zeroCount == 0) {
                result[i] = product / nums[i];
            } else {
                if (nums[i] != 0) result[i] = 0;
                else result[i] = product;
            }
        }

        return result;
    }
}

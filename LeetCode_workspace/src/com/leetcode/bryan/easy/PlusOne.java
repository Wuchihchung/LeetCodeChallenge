package com.leetcode.bryan.easy;

/**
 * https://leetcode.com/problems/plus-one/
 *
 * 1. 若是最低位+1後沒有進位, 則直接return最低位+1後的array, 拿原array去return
 * 2. 若是最低位+1後有進位的話, 則開始由最低位去走, 看是否需要持續進位, 若一發現不用進位, 則return原array
 * 3. Step2的過程中, 同步maintain一個length比原array大1的new array, 當維一一種特例, 就是原array
 *    為9,9,9,9,...這樣的特例時, 最終最左邊會多進位出一位, 此時就return new array
 *
 * Time : O(n)
 *
 */

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 0;
        int newAry[] = new int[len + 1];

        digits[len - 1] += 1;

        if (digits[len - 1] != 10) return digits;
        else {
            digits[len - 1] = 0;
            newAry[len] = 0;
            carry = 1;

            for (int i = len - 2; i >= 0; i--) {
                digits[i] += carry;

                if (digits[i] == 10) {
                    digits[i] = 0;
                    carry = 1;
                } else {
                    carry = 0;
                    return digits;
                }

                newAry[i + 1] = digits[i];
            }

            if (carry == 0)
                return digits;
            else {
                newAry[0] = 1;
                return newAry;
            }
        }
    }
}

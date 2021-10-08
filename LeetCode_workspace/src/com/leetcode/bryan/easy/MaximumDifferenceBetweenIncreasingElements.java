package com.leetcode.bryan.easy;


/**
 * https://leetcode.com/problems/maximum-difference-between-increasing-elements/
 *
 * 這題有點小tricky, 看似'Easy'等級但一下子還想不出O(n)的解法, 一不小心解法就會變成O(n2), 造成執行時間過長
 * 解法就是用2-pointers, i, j. i, j都由0開始, 把nums[i]當成目前的最小值, 然後j先往右走, 若nums[j] > nums[i]時, 則比對是不是當下的maxinum, 是的話就記錄下來
 * 如此j一直往右走, 當nums[j] < nums[i]時, 就把i移到j目前的位置, 意思就是目前而言更小的值已經出現了, 應該以這個最小值為基準來繼續之後的traverse
 * 用原本的nums[i]已經沒有意義
 *
 * Time : O(n)
 */

public class MaximumDifferenceBetweenIncreasingElements {
    public int maximumDifference(int[] nums) {
        int len = nums.length;
        int max = -1;
        int i = 0, j = 0;

        while (i < len - 1 && j < len - 1) {
            j++;

            if (j > i) {
                int diff = nums[j] - nums[i];
                if (diff > 0) max = Math.max(max, diff);
                else i = j;
            }
        }

        return max;
    }
}
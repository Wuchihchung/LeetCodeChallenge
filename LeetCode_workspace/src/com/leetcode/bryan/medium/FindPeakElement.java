package com.leetcode.bryan.medium;

/**
 * https://leetcode.com/problems/find-peak-element/
 *
 * 直接由題目的需求去直接linear比對即可, 時間複雜度會在O(n), 若要O(logn)則是用binary search, 也很直覺
 * 注意linear的比對, 其實只要遇到任相鄰的2 elements前者比後者大則就是答案了. 所以可以少比一次, 見leetcode提供的solution
 *
 * Time : O(n) or O(logn)
 *
 */

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;

        if (nums[0] > nums[1]) return 0;

        for (int i = 1; i < len - 1; i++) if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) return i;

        return len - 1;
    }
}

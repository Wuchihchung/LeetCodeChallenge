package com.leetcode.bryan.medium;

import java.util.Arrays;
import java.util.Comparator;


/**
 * https://leetcode.com/contest/weekly-contest-256/problems/find-the-kth-largest-integer-in-the-array/
 *
 * Same as https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 這題是字串版的, 整個計算過程不能有轉擜成integer的步驟, 因為會out of Java integer range. 所以sort的過程都要用字串的sort
 *
 * Time : O(nLogn)
 */

public class FindtheKthLargestIntegerintheArray {
    public String kthLargestNumber(String[] nums, int k) {

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) return s1.compareTo(s2);
                else return s1.length() - s2.length();
            }
        });

        int len = nums.length;

        return nums[len - k];
    }
}
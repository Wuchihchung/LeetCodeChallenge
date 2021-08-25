package com.leetcode.bryan.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * 1. 先全部element丟入hash set裏
 * 2. 精神上就是開始一個一個element去找針對這個element的連續數列有多長, 然後把最長的記起來
 * 3. 下面code裏 if 那行是一個tricky, 可以大量減少處理, 意思就是若該element不是連續最小的話就不去判斷, 因為可以拿比它小的那個去判斷
 *
 * Time : O(n)
 * 
 */

public class LongestConsecutiveSequence {
    Set<Integer> map;
    int nums[] = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};   //{100, 4, 200, 1, 3, 2};

    public LongestConsecutiveSequence() {
        map = new HashSet<>();
    }

    public int longestConsecutive() {
        int size = nums.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) map.add(nums[i]);

        for (int i = 0; i < size; i++) {
            if (!map.contains(nums[i]-1)) {  // <-- tricky tricky
                int count = 1;
                int increase = 1;

                while (map.contains(nums[i] + increase)) {
                    count++;
                    increase++;
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }
}
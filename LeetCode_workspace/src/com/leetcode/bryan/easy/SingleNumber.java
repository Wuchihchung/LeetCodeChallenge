package com.leetcode.bryan.easy;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/single-number/
 *
 * 跟 https://leetcode.com/problems/first-unique-character-in-a-string/
 * 這題其實是一樣的東西
 *
 * Time : O(n)
 */

public class SingleNumber {
    private static int nums[] = {4, 1, 2, 1, 2};

    public static int singleNumber() {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int value = map.getOrDefault(nums[i], -1);
            if (value == -1) map.put(nums[i], 1);
            else map.put(nums[i], ++value);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == 1)
                return key;
        }

        return -1;
    }
}

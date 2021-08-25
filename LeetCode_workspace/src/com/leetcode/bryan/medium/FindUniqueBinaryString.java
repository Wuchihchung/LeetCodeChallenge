package com.leetcode.bryan.medium;

import java.util.HashMap;
import java.util.HashSet;

public class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        HashMap<Integer, Integer> set = new HashMap<>();
        int len = nums[0].length();
        int n = (int)Math.pow(2, len);

        for (int i = 0; i < n; i++) set.put(i, 0);

        for (String num : nums) {
            int value = Integer.parseInt(num, 2);
            if (set.containsKey(value)) set.remove(value);
        }

        String rlt = "";

        for (int key : set.keySet()) {
            rlt = Integer.toBinaryString(key);
            break;
        }

        while (rlt.length() < len) rlt = "0" + rlt;
        return rlt;
    }
}

package com.leetcode.bryan.medium;

import java.util.HashMap;


public class DecodeWays {
    private HashMap<String, Integer> mem = new HashMap<>();

    public int numDecodings(String s) {
        int len = s.length();
        HashMap<String, Character> map = new HashMap<>();
        for (int value = 1; value <= 26; value++) map.put(String.valueOf(value), (char)(value + 0x40));

        int result = decodeString(s, map);
        return result;
    }

    private int decodeString(String s, HashMap<String, Character> map) {
        if (mem.containsKey(s)) return mem.get(s);

        int len = s.length();
        if (len == 0) return 0;
        if (len == 1) return map.containsKey(s) ? 1 : 0;

        int count = 0;
        int i = 1;
        int index = Math.min(3, s.length());
        while (i <= index) {
            String sub1 = s.substring(0, i);
            String sub2 = s.substring(i);

            if (map.containsKey(sub1)) {
                if (sub2.isEmpty()) {
                    count++;
                } else {
                    count += decodeString(sub2, map);
                }
            }

            i++;
        }

        mem.put(s, count);
        return count;
    }
}
package com.leetcode.bryan.medium;


import java.util.HashMap;

public class DistinctSubsequences {
    HashMap<String, HashMap<String, Integer>> map = new HashMap<>();

    public int numDistinct(String s, String t) {
        char[] arr_s = s.toCharArray();
        char[] arr_t = t.toCharArray();

        return checkMatchCount(arr_s, arr_t, 0, 0);
    }

    private int checkMatchCount(char[] arr_s, char[] arr_t, int index_s, int index_t) {
        String s = new String(arr_s, index_s, arr_s.length - index_s);
        String t = new String(arr_t, index_t, arr_t.length - index_t);

        if (map.containsKey(s)) {
            HashMap<String, Integer> match = map.get(s);

            if (match.containsKey(t)) return match.getOrDefault(t, 0);
        }

        if (index_t >= arr_t.length) return 0;

        int count = 0;

        for (int i = index_s; i < arr_s.length; i++) {
            if (arr_s[i] == arr_t[index_t]) {
                if (index_t == arr_t.length - 1) count += 1;
                else count += checkMatchCount(arr_s, arr_t, i + 1, index_t + 1);
            }
        }

        HashMap<String, Integer> match = map.getOrDefault(s, new HashMap<String, Integer>());
        match.put(t, count);
        map.put(s, match);

        return count;
    }
}
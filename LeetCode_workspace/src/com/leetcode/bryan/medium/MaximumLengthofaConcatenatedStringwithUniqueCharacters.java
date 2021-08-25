package com.leetcode.bryan.medium;

import java.util.*;


public class MaximumLengthofaConcatenatedStringwithUniqueCharacters {
    private static int ans;
    private static List<String> arr = Arrays.asList("abw", "b", "c", "dez", "gtvs");

    private static void backtrack(List<Integer> bits, final int current, final int start) {
        ans = Math.max(ans, Integer.bitCount(current));

        for (int i = start; i < bits.size(); i++) {
            int bit = bits.get(i);
            if ((current & bit) == 0) {
                backtrack(bits, current | bit, i + 1);
            }

            // no need to restore current
        }
    }

    // Use backtrack
    public static int maxLength() {
        ans = 0;

        List<Integer> bits = new ArrayList<>();
        for (String str : arr) {
            int bit = 0, dup = 0;
            for (char c: str.toCharArray()) {
                dup |= bit & (1 << (c - 'a'));
                bit |= (1 << (c - 'a'));
            }

            // skip string with dup char
            if (dup > 0) {
                continue;
            }

            bits.add(bit);
        }

        backtrack(bits, 0, 0);

        return ans;
    }
}

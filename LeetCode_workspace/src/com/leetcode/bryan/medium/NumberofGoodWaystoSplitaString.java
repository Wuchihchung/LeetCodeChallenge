package com.leetcode.bryan.medium;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 *
 * 從字串的左邊和右邊各走一次, 看看每種切法各個substring中含的不同字元的個數
 * 然後再拿左右比一次, 看哪些的字元個數是一樣的, 就是有符合
 *
 * Time : O(n)
 */

public class NumberofGoodWaystoSplitaString {
    private static String s = "aacaba";

    public static int numSplits() {
        int len = s.length();

        HashMap<String, Integer> left = new HashMap<>();
        HashMap<String, Integer> right = new HashMap<>();
        int split1[] = new int[len];
        int split2[] = new int[len];

        for (int idx = 0; idx < len - 1; idx++) {
            String subString = s.substring(idx, idx + 1);

            left.put(subString, 1);
            split1[idx] = left.size();
        }

        for (int idx = len-1; idx > 0; idx--) {
            String subString = s.substring(idx, idx + 1);

            right.put(subString, 1);
            split2[idx - 1] = right.size();
        }

        int hit = 0;
        for (int idx = 0; idx < len - 1; idx++) {
            if (split1[idx] == split2[idx + 1]) hit++;
        }

        return hit;
    }
}

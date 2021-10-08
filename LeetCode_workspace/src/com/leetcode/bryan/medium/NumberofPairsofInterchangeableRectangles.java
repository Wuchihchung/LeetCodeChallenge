package com.leetcode.bryan.medium;

import java.util.HashMap;


/**
 * https://leetcode.com/contest/weekly-contest-258/problems/number-of-pairs-of-interchangeable-rectangles/
 */

public class NumberofPairsofInterchangeableRectangles {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Long> map = new HashMap<>();

        for (int[] rect : rectangles) {
            double ratio = (double) rect[0] / (double)rect[1];

            long val = map.getOrDefault(ratio, 0L);
            val++;
            map.put(ratio, val);
        }

        long count = 0;
        for (double key : map.keySet()) {
            if (map.get(key) == 1L) continue;

            count += Combintion2Base(map.get(key));
        }

        return count;
    }

    private static long Combintion2Base(long n) { ;
        return n * (n - 1) / 2;
    }
}

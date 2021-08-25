package com.leetcode.bryan.medium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/merge-intervals/
 *
 * 1. 先針對interval的start去做sort, 不sort無法比對
 * 2. Sort完後再把裏面的interval一一拿出來檢視後放入output array
 *   2-1. 若output裏沒有interval, 則直接放入
 *   2-2. 若output裏有interval, 則拿出最後一個(理論上output裏都是不會overlap的)檢視, 若無overlap, 則將interval放入, 若有overlap, 則merge後再放入
 *
 * Time : O(NlogN)
 *
 */

public class MergeIntervals {
    LinkedList<int[]> output;
    //private int intervals[][] = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    private int intervals[][] = {{1, 4},{0, 0}};

    public MergeIntervals() {
        output  = new LinkedList<int[]>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    }

    public int[][] merge() {
        int size = intervals.length;

        for (int i = 0; i < size; i++) {
            if (output.size() == 0) output.add(intervals[i]);
            else {
                needMerge(output.getLast(), intervals[i]);
            }
        }

        return output.toArray(new int[output.size()][2]);
    }

    private void needMerge(int[] interval_1st, int[] interval_2nd) {
        if (interval_1st[1] < interval_2nd[0]) output.add(interval_2nd);
        else {
            int[] result = merge(interval_1st, interval_2nd);
            output.removeLast();
            output.add(result);
        }
    }

    private int[] merge(int[] interval_1st, int[] interval_2nd) {
        int low = Math.min(interval_1st[0], interval_2nd[0]);
        int high = Math.max(interval_1st[1], interval_2nd[1]);

        int[] interval_new = new int[2];
        interval_new[0] = low;
        interval_new[1] = high;

        return interval_new;
    }
}

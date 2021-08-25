package com.leetcode.bryan.medium;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/insert-interval/
 *
 * 先設定一個dirty flag, 用來記錄是否insert完成
 * 接著 :
 *  1. 如果flag = true, 則把剩餘的interval一一塞入output
 *  2. 如果flag = false, 則 :
 *    2-1 : merge interval在某個interval的左邊(無交集), 則塞入merge interval和這個interval, 設flag = true
 *    2-2 : 如果merge interval在某個interval的右邊(無交集), 則塞入這個interval
 *    2-3 : 如果merge interval跟某個interval有交集, 則實行merge
 *
 * Time : O(n)
 */

public class InsertInterval {
    //private static int intervals[][] = {{1, 2},{3, 5},{6, 7},{8, 10},{12, 16}};
    //private static int newInterval[] = {4, 8};
    private static int intervals[][] = {{1, 3}, {2, 6}, {8, 10}};
    private static int newInterval[] = {15, 18};

    public static int[][] insert() {
        int[][] output;
        output = doInsert(intervals, newInterval);

        return output;
    }

    private static int[][] doInsert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        boolean bFinished = false;
        int[] mergedInterval = newInterval;
        LinkedList<int[]> output = new LinkedList<int[]>();

        if (intervals.length == 0) {
            System.out.println(mergedInterval[0] + ", " + mergedInterval[1]);
            output.add(mergedInterval);
        }

        if (newInterval.length == 0) {
            bFinished = true;
        }

        for (int idx = 0; idx < len; idx++) {
            if (bFinished) {
                System.out.println(intervals[idx][0] + ", " + intervals[idx][1]);
                output.add(intervals[idx]);
            }
            else if (mergedInterval[1] < intervals[idx][0]) {
                System.out.println(mergedInterval[0] + ", " + mergedInterval[1]);
                System.out.println(intervals[idx][0] + ", " + intervals[idx][1]);

                output.add(mergedInterval);
                output.add(intervals[idx]);
                bFinished = true;
            }
            else if (mergedInterval[0] > intervals[idx][1]) {
                System.out.println(intervals[idx][0] + ", " + intervals[idx][1]);
                output.add(intervals[idx]);

                if (idx == len -1) {
                    System.out.println(mergedInterval[0] + ", " + mergedInterval[1]);
                    output.add(mergedInterval);
                }
            }
            else {
                mergedInterval = merge(intervals[idx], mergedInterval);
                if (idx == len -1) {
                    System.out.println(mergedInterval[0] + ", " + mergedInterval[1]);
                    output.add(mergedInterval);
                }
            }
        }

        return output.toArray(new int[output.size()][2]);
    }

    private static int[] merge(int[] interval_1st, int[] interval_2nd) {
        int low = Math.min(interval_1st[0], interval_2nd[0]);
        int high = Math.max(interval_1st[1], interval_2nd[1]);

        int[] interval_new = new int[2];
        interval_new[0] = low;
        interval_new[1] = high;

        return interval_new;
    }
}

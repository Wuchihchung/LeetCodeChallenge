package com.leetcode.bryan.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


class JobSchedulingData {
    public int start;
    public int end;
    public int profit;

    JobSchedulingData(int s, int e, int f) {
        start = s;
        end = e;
        profit = f;
    }
}

public class MaximumProfitinJobScheduling {
    private int maxProfit = 0;
    HashMap<Integer, Integer> map;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        map = new HashMap<>();
        JobSchedulingData[] jsd = new JobSchedulingData[startTime.length];

        for (int i = 0; i < startTime.length; i++) jsd[i] = new JobSchedulingData(startTime[i], endTime[i], profit[i]);
        Arrays.sort(jsd, new Comparator<JobSchedulingData>() {
            @Override
            public int compare(JobSchedulingData d1, JobSchedulingData d2) {
                return d1.start - d2.start;
            }
        });

        for (int i = 0; i < jsd.length; i++) {
            startTime[i] = jsd[i].start;
            endTime[i] = jsd[i].end;
            profit[i] = jsd[i].profit;
        }

        for (int i = 0; i < startTime.length; i++) {
            int maxCurr = profit[i] + getMaxProfit(i, startTime, endTime, profit);
            maxProfit = Math.max(maxCurr, maxProfit);
        }

         return maxProfit;
    }

    private int getMaxProfit(int curStart, int[] startTime, int[] endTime, int[] profit) {
        int index = -1;
        for (int i = curStart + 1; i < startTime.length; i++) {
            if (startTime[i] >= endTime[curStart]) {
                index = i;
                break;
            }
        }

        if (index == -1) return 0;
        if (index == startTime.length - 1) return profit[index];    // <-- 只剩下最後一個job
        if (index == startTime.length - 2) return Math.max(profit[index], profit[index + 1]);

        int max = 0;
        if (map.containsKey(index)) {
            return map.get(index);
        }

        for (int i = index; i < startTime.length; i++) {
            int maxCurr = profit[i] + getMaxProfit(i, startTime, endTime, profit);
            max = Math.max(maxCurr, max);
        }

        map.put(index, max);
        return max;
    }
}
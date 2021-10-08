package com.leetcode.bryan.medium;

import java.util.Collections;
import java.util.PriorityQueue;


/**
 *
 */

public class MinimizeMaxDistancetoGasStation {
    public double minmaxGasDist(int[] stations, int k) {
        PriorityQueue<Double> pq = new PriorityQueue<Double>(Collections.reverseOrder());

        for (int s = 1; s < stations.length; s++) pq.add(stations[s] - stations[s - 1] + 0.0);

        while (k > 0) {
            double max = pq.remove();
            pq.add(max / 2);
            pq.add(max / 2);

            k--;
        }

        return pq.remove();
    }
}
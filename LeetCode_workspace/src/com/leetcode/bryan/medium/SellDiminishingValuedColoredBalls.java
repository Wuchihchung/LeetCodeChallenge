package com.leetcode.bryan.medium;


import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SellDiminishingValuedColoredBalls {
    public int maxProfit(int[] inventory, int orders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stick : inventory) pq.add(stick);

        int cost = 0;
        while (orders > 0) {
            int value = pq.remove();
            cost += value;
            value--;
            orders--;

            pq.add(value);
        }

        return cost;
    }
}
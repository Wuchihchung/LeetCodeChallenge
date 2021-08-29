package com.leetcode.bryan.easy;

import java.util.LinkedList;
import java.util.List;


public class MinStack {
    private List<Integer> list;
    private int minValue;

    public MinStack() {
        list = new LinkedList<>();
        minValue = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (list.add(val))
            minValue = Math.min(minValue, val);
    }

    public void pop() {
        int min = list.get(list.size() - 1);
        list.remove(list.size() - 1);

        if (min == minValue) {
            minValue = Integer.MAX_VALUE;
            for (int i = 0; i < list.size(); i++) minValue = Math.min(minValue, list.get(i));
        }
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return minValue;
    }
}
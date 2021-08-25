package com.leetcode.bryan.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MaxStack {
    private List<Integer> list;
    private int maxValue;
    private int index;

    /** initialize your data structure here. */
    public MaxStack() {
        list = new LinkedList<>();
        maxValue = Integer.MIN_VALUE;
    }

    public void push(int x) {
        if (list.add(x)) {
            if (x >= maxValue) {
                maxValue = x;
                index = list.size() - 1;

                System.out.println("max : " + maxValue + " index = " + index);
            }
        }
    }

    public int pop() {
        int max = list.get(list.size() - 1);
        list.remove(list.size() - 1);

        if (max == maxValue) {
            maxValue = Integer.MIN_VALUE;

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > maxValue) {
                    maxValue = list.get(i);
                    index = i;
                }
            }
        }

        return max;
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int peekMax() {
        return maxValue;
    }

    public int popMax() {
        System.out.println("index = " + index);
        list.remove(index);
        int max = maxValue;
        System.out.println("max = " + max);

        maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i) >= maxValue) {
                System.out.println("i = " + i);
                maxValue = list.get(i);
                index = i;
            }
        }

        System.out.println("max = " + max + " index = " + index);
        return max;
    }
}

package com.leetcode.bryan.medium;

import java.util.TreeMap;


/**
 * https://leetcode.com/problems/my-calendar-i/
 *
 * Requests : 需要一個可以儲存所有calendar的data structure, 並且每次塞入新的calendar時可以判斷是否有衝突
 *
 * 本範例利用Java TreeMap當儲存體, 重點是insert後, 各個element是照著其key值的大小去排序的
 *
 */

public class MyCalendarI {
    TreeMap<Integer, Integer> calendar;

    void MyCalendar() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}
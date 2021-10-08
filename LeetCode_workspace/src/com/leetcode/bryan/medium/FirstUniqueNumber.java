package com.leetcode.bryan.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class FirstUniqueNumber {
    HashSet<Integer> set;
    List<Integer> list;

    public FirstUniqueNumber(int[] nums) {
        set = new HashSet<>();
        list = new ArrayList<>();

        for (int num : nums) {
            if (set.contains(num)) continue;

            if (list.indexOf(num) == -1) list.add(num);
            else {
                boolean rlt = list.remove(new Integer(num));
                set.add(num);
            }
        }
    }

    public int showFirstUnique() {
        return (list.size() == 0) ? -1 : list.get(0);
    }

    public void add(int value) {
        if (set.contains(value)) return;

        if (list.indexOf(value) == -1) list.add(value);
        else {
            boolean rlt = list.remove(new Integer(value));
            set.add(value);
        }
    }
}
package com.leetcode.bryan.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class FindKClosestElements {
    class DiffValue {
        public int value;
        public int diff;
    };

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        DiffValue diff[] = new DiffValue[len];

        for (int a = 0; a < len; a++) {
            diff[a] = new DiffValue();

            diff[a].value = arr[a];
            diff[a].diff = Math.abs(arr[a] - x);
        }

        Arrays.sort(diff, new Comparator<DiffValue>() {
            @Override
            public int compare(DiffValue d1, DiffValue d2) {
                return d1.diff - d2.diff;
            }
        });

        Integer v[] = new Integer[k];
        for (int index = 0; index < k; index++) v[index] = diff[index].value;

        Arrays.sort(v);
        List<Integer> list = Arrays.asList(v);
        return list;
    }
}

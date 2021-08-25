package com.leetcode.bryan.medium;

import java.util.ArrayList;
import java.util.List;


/**
 * https://leetcode.com/problems/permutations/
 *
 * 精神上就是用recursive的方式, 先把1個element放入list, 再用recursion把剩下的n-1的elements用同樣的function放入同一個list
 * 製造出全部的permutations
 * Recursive的寫法code很難搞懂, 需要簡易化
 *
 * Time : ??
 *
 */

public class Permutations {
    private static List<List<Integer>> list = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        list.clear();

        List<Integer> subList = new ArrayList<>();
        getPermutation(nums, subList);

        return list;
    }

    private void getPermutation(int[] array, List<Integer> subList) {
        int len = array.length;
        //List<Integer> subList = new ArrayList<>();

        if (len == 1) {
            subList.add(array[0]);
            list.add(subList);
        } else if (len == 2) {
            List<Integer> s1 = new ArrayList<>(subList);
            List<Integer> s2 = new ArrayList<>(subList);

            s1.add(array[0]);
            s1.add(array[1]);
            list.add(s1);

            s2.add(array[1]);
            s2.add(array[0]);
            list.add(s2);
        } else {
            for (int i = 0; i < len; i++) {
                List<Integer> dummy = new ArrayList<>(subList);
                dummy.add(array[i]);
                int[] subarray = copyArray(array, i);
                getPermutation(subarray, dummy);
                //list.add(subList);

                //subList.clear();
            }
        }
    }

    private int[] copyArray(int[] origin, int indexRemove) {
        if (origin == null
                || indexRemove < 0
                || indexRemove >= origin.length) {

            return origin;
        }

        int[] newArray = new int[origin.length - 1];

        for (int i = 0, k = 0; i < origin.length; i++) {
            if (i == indexRemove) continue;

            newArray[k++] = origin[i];
        }

        return newArray;
    }
}

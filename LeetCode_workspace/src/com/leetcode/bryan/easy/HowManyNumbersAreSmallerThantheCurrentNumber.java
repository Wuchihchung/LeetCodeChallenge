package com.leetcode.bryan.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 *
 *  先準備一個hash map
 * 1. 先對arrary進行sort, 不sort無法知道大小
 * 2. 將sort過的arrary裏的element由大至小放入hash map, element的值是hash key, element的index是hash value
 *    element的index的意義就是表示該element是第幾大(含考慮重覆value的element), 反而言也就是有幾個比該element小
 * 3. 將原本array裏的element依序將其index取出, 就是結果
 *
 */

public class HowManyNumbersAreSmallerThantheCurrentNumber {
    private static int nums[] = {8, 1, 2, 2, 3};
    //private static int nums[] = {4, 0, 1, 1, 3};

    public static int[] smallerNumbersThanCurrent() {
        int[] dummy;
        dummy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(dummy);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int idx = dummy.length - 1; idx >= 0; idx--)
            map.put(dummy[idx], idx);

        for (int idx = 0; idx < nums.length; idx++)
            dummy[idx] = map.get(nums[idx]);

        return dummy;
    }
}

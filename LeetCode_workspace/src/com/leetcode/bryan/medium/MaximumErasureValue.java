package com.leetcode.bryan.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-erasure-value/
 *
 * 這題題目的意思是在原array中取出一個subarray, 讓這個subarray裏所有的element值加起來是最大的
 * 比較tricky的點是這裏subarray的定義是指連續的element但不可重復, 這是比較特殊的地方
 *
 * 法1是用brute的方式, 從index = 0 到 n-1去check, 看從每個index當第一個element時, 可以找到多大的subarray. 這種的方式會接近O(n2)
 * 法2是用比較smart的方式, 去除法1裏一些不必要的判斷. 先由第0個element開始, 往下找, 找到最大的subarray, 假設此時的第1個element和最後一個element分別為start, end
 * 接著end往下一個(理論上此時就會立即造成重覆的element), 然後start再往前前移, 一直移到重覆element狀況消失), 接著再把end往下移一個, 一直重覆做...
 * 在上述的過程中也一直記錄最大的subarray, 一直到end到array的最後一個element為止
 * 法2的精神就是先找到一個最大subarray後, 再去調整end/start的位置, 找到下一個最大subarray, 並不斷的記錄最大值. O(n)
 *
 */

public class MaximumErasureValue {
    private static int[] nums = {4, 2, 4, 5, 6};
    private static int maxLen = 0;
    private static Map<Integer, Integer> map = new HashMap<>();

    public static int maximumUniqueSubarray() {
        int n = nums.length;
        int result = 0;
        HashSet set = new HashSet<>();
        for (int start = 0; start < n; start++) {
            // reset set and current sum for next subarray
            set.clear();
            int currentSum = 0;
            for (int end = start; end < n && !set.contains(nums[end]); end++) {
                currentSum += nums[end];
                set.add(nums[end]);
            }

            // update result with maximum sum found so far
            result = Math.max(result, currentSum);
        }

        return result;
    }

    /* public int maximumUniqueSubarray(int[] nums) {
        int result = 0;
        int currentSum = 0;
        HashSet<Integer> set = new HashSet<>();
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            // increment start until subarray has unique elements
            while (set.contains(nums[end])) {
                set.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }
            currentSum += nums[end];
            set.add(nums[end]);
            // update result with maximum sum found so far
            result = Math.max(result, currentSum);
        }
        return result;
    } */
}

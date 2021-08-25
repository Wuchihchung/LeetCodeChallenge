package com.leetcode.bryan.hard;


/* Question : 給定一個沒有sort過的int array, 裏面可能有0, 負整數, 正整數
 *            求最小的missing正整數
 *
 *       Ex :
 *              Input: nums = [3,4,-1,1]
 *              Output: 2
 *
 * Requirement :
 *      Time : O(n)
 *      Space : O(1)
 *
 * Solution(by poster) :
 *      對一個size為n的array, 最大的missing正整數為n+1, 當這個array為{1, 2, 3,..., n}時
 *      也就是說只要觀察這個array裏1~n存在的狀況, 其它負整數, 0, 大於n的正整數都不用管
 *
 *      作法是把每個1~n的的值換到對應array index裏去, ex array[0] = 3, 就把3換到array[2]去
 */

public class FirstMissingPositive {
    private static int nums[] = {7, 8, 9, 11, 1};

    public static int firstMissingPositive() {
        int n = nums.length;

        for (int i = 0; i < n; i++){
            while (0 < nums[i] && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                //swap
                int t = nums[i];
                nums[i] = nums[t-1];
                nums[t-1] = t;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i+1)
                return i+1;
        }

        return n + 1;
    }
}

package com.leetcode.bryan.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/
 *
 * 作法很直覺, 就是把字串從頭到尾掃一遍, 沒有重復的字元不理, 有重復的就cost最大的留下, 其它全部刪除, 也就是把cost全部累加下來
 *
 * Time : O(N)
 *
 */

public class MinimumDeletionCosttoAvoidRepeatingLetters {
    public int minCost() {
        //String s = "abaac";
        //int cost[] = {1, 2, 3, 4, 5};
        //String s = "abc";
        //int cost[] = {1, 2, 3};
        String s = "aabaa";
        int cost[] = {1, 2, 3, 4, 1};

        int len = s.length();
        char[] arr = s.toCharArray();

        int count;     /* the total cost of current repeating letters */
        int max;    /* the maximum cost of current repeating letters */
        int minCost = 0;    /* final minimum cost we will return */
        int j;

        for (int i = 0; i < len - 1;) {
            j = i + 1;

            count = cost[i];    /* initialized by the cost of 1st repeating letter */
            max = cost[i];  /* initialized by the cost of 1st repeating letter */

            while (j < len && arr[j] == arr[i]) {
                count += cost[j];   /* add each cost of the repeating letter */
                max = Math.max(max, cost[j]);   /* store the maximum cost among these repeating letter */

                j++;
            }

            minCost += count - max; /* add up the count beside the maximum value
                                     * if it's a single letter, then count = max, so there's no impact here
                                     */
            i = j;
        }

        return minCost;
    }
}

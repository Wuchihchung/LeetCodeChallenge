package com.leetcode.bryan.hard;


/**
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3889/
 *
 * 這題難度高, 待comment
 */

public class RemoveBoxes {
    public int removeBoxes(int[] boxes) {
        int size = boxes.length;
        int[][][] mem = new int[size][size][size];
        return dfs(boxes, mem, 0, size - 1, 0);
    }

    private int dfs(int[] boxes, int[][][] mem, int l, int r, int k) {
        if (l > r) return 0;

        if (mem[l][r][k] > 0) return mem[l][r][k];

        while (r > l && boxes[r] == boxes[r - 1]) {
            r--;
            k++;
        }

        mem[l][r][k] = dfs(boxes, mem, l, r - 1, 0 ) + (k + 1) * (k + 1);

        for (int i = l; i < r; i++) {
            if (boxes[i] == boxes[r]) {
                mem[l][r][k] = Math.max(mem[l][r][k], dfs(boxes, mem, l, i, k + 1) + dfs(boxes, mem, i + 1, r - 1, 0));
            }
        }

        return mem[l][r][k];
    }
}

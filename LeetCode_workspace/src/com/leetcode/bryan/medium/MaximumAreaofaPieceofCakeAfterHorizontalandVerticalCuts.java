package com.leetcode.bryan.medium;


import java.util.Arrays;

public class MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCuts {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long max_H = horizontalCuts[0];
        long max_V = verticalCuts[0];

        for (int i = 1; i < horizontalCuts.length; i++) max_H = Math.max(max_H, horizontalCuts[i] - horizontalCuts[i - 1]);
        for (int i = 1; i < verticalCuts.length; i++) max_V = Math.max(max_V, verticalCuts[i] - verticalCuts[i - 1]);

        max_H = Math.max(max_H, h - horizontalCuts[horizontalCuts.length - 1]);
        max_V = Math.max(max_V, w - verticalCuts[verticalCuts.length - 1]);

        //return max_H * max_V;
        return (int) ((max_H * max_V) % (1000000007));
    }
}
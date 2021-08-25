package com.leetcode.bryan.easy;

/**
 *
 */

public class SumofSquareNumbers {
    public boolean judgeSquareSum(int c) {

        int sqr = (int)Math.sqrt(c);
        for (int i = 0; i < sqr; i++) {
            int a2 = i * i;
            if (a2 > c) return false;
            if (a2 == c) return true;

            int b2 = c - a2;
            if (advancedIsSquare(b2)) return true;
        }

        return false;
    }

    private boolean advancedIsSquare(int num) {
        double a = 0;
        try {
            a = Math.sqrt(num);
        } catch (Exception e) {
            return false;
        }

        int b = (int)a;
        return a - b == 0;
    }
}

package com.leetcode.bryan.easy;

public class NthTribonacciNumber {
    int[] buff;

    public NthTribonacciNumber() {
        buff = new int[38];
        buff[0] = 0;
        buff[1] = 1;
        buff[2] = 1;

        for (int i = 3; i < 38; i++) buff[i] = buff[i - 1] + buff[i - 2] + buff[i - 3];
    }

    public int tribonacci(int n) {
        return buff[n];
    }
}
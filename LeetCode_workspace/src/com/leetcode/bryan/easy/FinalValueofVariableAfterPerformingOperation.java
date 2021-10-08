package com.leetcode.bryan.easy;


public class FinalValueofVariableAfterPerformingOperation {
    public int finalValueAfterOperations(String[] operations) {
        int val = 0;

        for (String op : operations) {
            char c = op.charAt(1);

            switch(c) {
                case '+' :
                    val++;
                    break;
                case '-' :
                    val++;
                    break;
                default :
                    break;
            }
        }

        return val;
    }
}

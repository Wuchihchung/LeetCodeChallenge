package com.leetcode.bryan.easy;

public class NumberofStringsThatAppearasSubstringsinWor {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;

        for (String pattern : patterns)
            if (word.indexOf(pattern) != -1) count++;

        return count;
    }
}

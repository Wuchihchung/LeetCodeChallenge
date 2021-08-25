package com.leetcode.bryan.medium;

import java.util.HashMap;
import java.util.Map;


public class FindAndReplaceinString {
    private static String S = "fvokzonyhukpwbnkomdianhirsvdulhsfseaqzktupyeverfsd";
    private static int indexes[] = {26, 30, 38, 2, 41, 10, 8, 44, 19, 4, 13, 28, 21, 35, 23, 16};
    private static String sources[] = {"vd", "hsfs", "ktu", "ok", "pye", "kp", "hu", "verfs", "ia", "zon", "bnk", "ul", "nh", "aqz", "irs", "om"};
    private static String targets[] = {"h", "gdlf", "nl", "sr", "xhn", "ax", "arf", "ifuax", "a", "mk", "vwqe", "fdl", "n", "miyr", "ibh", "den"};

    public static String findReplaceString() {
        StringBuilder result = new StringBuilder();
        Map<Integer,Integer> map = new HashMap<>();

        for (int i =0;i<indexes.length; i++) {
            map.put(indexes[i], i);
        }

        int i =0;
        while (i < S.length()) {
            Integer actualIndex = map.get(i);

            if (actualIndex != null && S.indexOf(sources[actualIndex], i) == i) {
                result.append(targets[actualIndex]);
                i = i + sources[actualIndex].length();
            }else{
                result.append(S.charAt(i));
                i++;
            }
        }

        return result.toString();
    }
}

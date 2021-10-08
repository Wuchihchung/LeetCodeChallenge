package com.leetcode.bryan.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        List<String> list = new ArrayList<>();

        char[] arr = s.toCharArray();
        String num = "0";

        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                num += arr[i];
                continue;
            }

            if (arr[i] == '-' || arr[i] == '+') {
                list.add(num);
                list.add(String.valueOf(arr[i]));
                num = "0";
            }
        }

        list.add(num);
        int num1 = 0;
        int result = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("+")) {
                result += (num1 + Integer.valueOf(list.get(i + 1)));
                i++;
                num1 = 0;
                continue;
            }

            if (list.get(i).equals("-")) {
                result += (num1 - Integer.valueOf(list.get(i + 1)));
                i++;
                num1 = 0;
                continue;
            }

            num1 = Integer.valueOf(list.get(i));
        }

        if (list.size() == 1) result = Integer.valueOf(list.get(0));

        return result;
    }
}

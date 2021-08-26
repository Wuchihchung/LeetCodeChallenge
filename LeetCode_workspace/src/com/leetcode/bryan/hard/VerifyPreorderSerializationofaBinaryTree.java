package com.leetcode.bryan.hard;

import java.util.Arrays;
import java.util.HashMap;

public class VerifyPreorderSerializationofaBinaryTree {
    HashMap<String, Boolean> map;

    public boolean isValidSerialization(String preorder) {
        int capacity = 1;

        preorder += ",";

        for (int i = 0; i < preorder.length(); ++i) {
            String sub1 = preorder.substring(i, i + 1);

            if (!sub1.equals(",")) continue;
            if (--capacity < 0) return false;

            String sub2 = preorder.substring(i - 1, i);
            if (!sub2.equals("#")) capacity += 2;
        }

        return capacity == 0;
    }

    private boolean isValid(String[] order) {
        String key = String.join(",", order);

        if (map.containsKey(key)) {
            //System.out.println("dfsfd");
            return map.get(key);
        }

        int len = order.length;

        if (len == 1) {
            //System.out.println("1");

            boolean nullNode = order[0].equals("#") ? true : false;
            return nullNode;       // <-- 當只有一個node時, 只能是null, 不然至少要三個node才合理
        }

        if (len == 2) {
            //System.out.println("2");

            return false;
        }

        if (order[0].equals("#")) {
            //System.out.println("3");

            return false;
        }

        for (int i = 1; i < len - 1; i++) {
            String[] lefTree = Arrays.copyOfRange(order, 1, i + 1);
            String[] rightTree = Arrays.copyOfRange(order, i + 1, len);

            if (isValid(lefTree) && isValid(rightTree)) {
                return true;
            }

            //System.out.println("4");
        }

        map.put(key, false);
        return false;
    }
}

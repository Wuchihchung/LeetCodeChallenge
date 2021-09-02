package com.leetcode.bryan.medium;

import com.leetcode.bryan.common.TreeNode;
import java.util.HashMap;


/**
 * https://leetcode.com/explore/featured/card/august-leetcoding-challenge-2021/617/week-5-august-29th-august-31st/3955/
 *
 */

public class EqualTreePartition {
    HashMap<Integer, Integer> left = new HashMap<>();
    HashMap<Integer, Integer> right = new HashMap<>();
    private int totalSum = 0;
    private boolean hasEqualTree = false;

    public boolean checkEqualTree(TreeNode root) {
        int index = 1;
        dfsSumOfSubtree(root, index);
        totalSum = left.getOrDefault(1, 0) + right.getOrDefault(1, 0) + root.val;

        dfsCheckEqualTree(root, index);
        return hasEqualTree;
    }

    private void dfsCheckEqualTree(TreeNode root, int index) {
        if (root == null) return;
        if (hasEqualTree) return;

        if (left.containsKey(index)) {
            int val1 = left.get(index);
            if (val1 == totalSum - val1) {
                hasEqualTree = true;
                return;
            }
        }

        if (right.containsKey(index)) {
            int val2 = right.get(index);
            if (val2 == totalSum - val2) {
                hasEqualTree = true;
                return;
            }
        }

        dfsCheckEqualTree(root.left, index * 2);
        dfsCheckEqualTree(root.right, index * 2 + 1);
    }

    private void dfsSumOfSubtree(TreeNode node, int index) {
        if (node == null) return;

        int div = index / 2;
        int rest = index % 2;

        while (div > 0) {
            int value;

            if (rest == 0) {
                value = left.getOrDefault(div, 0);
                value += node.val;
                left.put(div, value);
            } else {
                value = right.getOrDefault(div, 0);
                value += node.val;
                right.put(div, value);
            }

            rest = div % 2;
            div /= 2;
        }

        dfsSumOfSubtree(node.left, index * 2);
        dfsSumOfSubtree(node.right, index * 2 + 1);
    }
}
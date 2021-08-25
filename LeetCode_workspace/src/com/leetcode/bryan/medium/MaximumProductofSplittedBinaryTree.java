package com.leetcode.bryan.medium;
import com.leetcode.bryan.common.TreeNode;

import java.util.HashMap;

/**
 *
 */

public class MaximumProductofSplittedBinaryTree {
    HashMap<Integer, Integer> left = new HashMap<>();
    HashMap<Integer, Integer> right = new HashMap<>();
    private int totalSum = 0;
    private int maxProd = Integer.MIN_VALUE;

    public int maxProduct(TreeNode root) {
        left.clear();
        right.clear();
        totalSum = 0;
        maxProd = Integer.MIN_VALUE;

        int index = 1;
        dfs(root, index);
        totalSum = left.getOrDefault(1, 0) + right.getOrDefault(1, 0) + root.val;

        int maxProd = dfsProduct(root, index);
        return maxProd;
    }

    private int dfsProduct(TreeNode root, int index) {
        if (root == null) return 0;

        int val1 = left.getOrDefault(index, 0);
        int val2 = right.getOrDefault(index, 0);

        int prod1 = val1 * (totalSum - val1);
        int prod2 = val2 * (totalSum - val2);
        int prod3 = Math.max(prod1, prod2);
        int prod4 = dfsProduct(root.left, index * 2);
        int prod5 = dfsProduct(root.right, index * 2 + 1);
        int prod6 = Math.max(prod4, prod5);
        int prod7 = Math.max(prod3, prod6);

        maxProd = Math.max(maxProd, prod7);
        return maxProd;
    }

    private void dfs(TreeNode node, int index) {
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

        dfs(node.left, index * 2);
        dfs(node.right, index * 2 + 1);
    }
}

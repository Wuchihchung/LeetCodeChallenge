package com.leetcode.bryan.medium;

import com.leetcode.bryan.common.TreeNode;
import java.util.HashMap;


/**
 * https://leetcode.com/problems/maximum-average-subtree/
 */

public class MaximumAverageSubtree {
    HashMap<Integer, Integer> mapSum = new HashMap<>();
    HashMap<Integer, Integer> mapNodes = new HashMap<>();
    double maxAverage = Double.MIN_VALUE;

    public double maximumAverageSubtree(TreeNode root) {
        dfsSumOfSubtree(root, 1);
        return maxAverage;
    }

    private int dfsSumOfSubtree(TreeNode node, int id) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            mapSum.put(id, node.val);
            mapNodes.put(id, 1);

            maxAverage = Math.max(maxAverage, (double)node.val);
            return node.val;
        }

        int value = node.val + dfsSumOfSubtree(node.left, id * 2) + dfsSumOfSubtree(node.right, id * 2 + 1);
        mapSum.put(id, value);
        int subTreeNodes = mapNodes.getOrDefault(id * 2, 0) + mapNodes.getOrDefault(id * 2 + 1, 0);
        mapNodes.put(id, subTreeNodes + 1);

        maxAverage = Math.max(maxAverage, (double)value / (subTreeNodes + 1));
        return value;
    }

    /*private void dfsSumOfSubtree(TreeNode node, int id) {
        if (node == null) return;

        List<Integer> list = map.getOrDefault(id, new ArrayList<>());
        if (list.size() == 0) {
            list.add(node.val);
        }

        if (node.left != null) list.add(id * 2);
        if (node.right != null) list.add(id * 2 + 1);

        map.put(id, list);

        dfsSumOfSubtree(node.left,  id * 2);
        dfsSumOfSubtree(node.right, id * 2 + 1);
    }*/
}

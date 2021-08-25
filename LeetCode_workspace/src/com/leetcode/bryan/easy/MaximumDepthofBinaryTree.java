package com.leetcode.bryan.easy;

import com.leetcode.bryan.common.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Recursive的走完每一個node, 最高深度 = 1(root) + max(左樹深度, 右樹深度)
 *
 */

public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) return 1;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}

package com.leetcode.bryan.medium;

import com.leetcode.bryan.common.TreeNode;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */

public class CountGoodNodesinBinaryTree {
    public int goodNodes(TreeNode root) {
        return dfs(root,Integer.MIN_VALUE);
    }

    private int dfs(TreeNode root , int maxSoFar){
        if (root == null) return 0;

        int numGoodNodes = 0;
        if (root.val >= maxSoFar)
            numGoodNodes++;

        numGoodNodes += dfs(root.left,Math.max(root.val,maxSoFar));
        numGoodNodes += dfs(root.right,Math.max(root.val,maxSoFar));

        return numGoodNodes;
    }
}

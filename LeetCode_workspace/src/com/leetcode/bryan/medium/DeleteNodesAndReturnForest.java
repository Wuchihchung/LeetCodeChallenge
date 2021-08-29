package com.leetcode.bryan.medium;

import com.leetcode.bryan.common.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class DeleteNodesAndReturnForest {
    List<TreeNode> list = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        list.clear();
        list.add(root);

        HashSet<Integer> set = new HashSet<>();
        for (int val : to_delete) set.add(val);

        dfsChekDeletion(root, set);
        dfsRemoveDeleteion(root);

        return list;
    }

    private void dfsRemoveDeleteion(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        if (root.val == -1) {
            root = null;
            list.add(left);
            list.add(right);
        }

        //dfsRemoveDeleteion(true, left);
        //dfsRemoveDeleteion(true, right);
    }

    private void dfsChekDeletion(TreeNode node, HashSet<Integer> set) {
        if (node == null) return;

        if (set.contains(node.val)) node.val = -1;
        dfsChekDeletion(node.left, set);
        dfsChekDeletion(node.right, set);
    }
}

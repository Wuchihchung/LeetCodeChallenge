package com.leetcode.bryan.medium;
import com.leetcode.bryan.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3908/
 *
 */

public class TwoSumIV {
    private boolean result = false;

    public boolean findTarget(TreeNode root, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        dumpTrees(root, k, map);

        return result;
    }

    private void dumpTrees(TreeNode root, int k, HashMap<Integer, Integer> map) {
        if (result) return;
        if (root == null) return;

        int diff = k - root.val;
        if (map.containsKey(diff)) {
            result = true;
        } else {
            map.put(root.val, 1);
        }

        dumpTrees(root.left, k, map);
        dumpTrees(root.right, k, map);
    }
}

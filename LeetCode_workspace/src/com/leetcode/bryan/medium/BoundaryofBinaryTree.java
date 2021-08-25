package com.leetcode.bryan.medium;

import java.util.ArrayList;
import java.util.List;
import com.leetcode.bryan.common.TreeNode;

/**
 * https://leetcode.com/problems/boundary-of-binary-tree/
 * 說明 : https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 *
 * 一個binary tree的boundary的意義就是從root開始逆時鐘時向去遍歷這棵樹一圈, 看經過這棵樹外圍的哪些node, 都把他們收集起來
 * 下例code裏實際作法是分為4步驟 :
 *
 * 1. 先"由上至下"遍歷left subtree的boundary nodes (不含leaf node)
 * 2. 遍歷(由左至右)left subtree的leaves
 * 3. 遍歷(由左至右)right subtree的leaves
 * 4. "由下至上"遍歷right subtree的boundary nodes (不含leaf node)
 *
 * Code寫的很精簡, 程度很高, 需多看幾遍
 *
 * Time : O(N)
 */

class BinaryTree {
    TreeNode root;
    public List<Integer> list;

    BinaryTree(TreeNode node) {
        root = node;
        list = new ArrayList<>();
    }

    // A simple function to print leaf nodes of a binary tree
    void printLeaves(TreeNode node) {
        if (node == null)
            return;

        // Print it if it is a leaf node
        if (node.left == null && node.right == null) {
            //System.out.print(node.data + " ");
            list.add(node.val);
            return;     // <-- it's no problem if we don't return here since in the beginning it will have null check
        }

        printLeaves(node.left);
        printLeaves(node.right);
    }

    // A function to print all left boundary nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    void printBoundaryLeft(TreeNode node)
    {
        if (node == null)
            return;

        if (node.left != null) {
            // to ensure top down order, print the node
            // before calling itself for left subtree
            //System.out.print(node.data + " ");
            list.add(node.val);
            printBoundaryLeft(node.left);
        }
        else if (node.right != null) {
            //System.out.print(node.data + " ");
            list.add(node.val);
            printBoundaryLeft(node.right);
        }

        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    // A function to print all right boundary nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    void printBoundaryRight(TreeNode node)
    {
        if (node == null)
            return;

        if (node.right != null) {
            // to ensure bottom up order, first call for right
            // subtree, then print this node
            printBoundaryRight(node.right);
            //System.out.print(node.data + " ");
            list.add(node.val);
        }
        else if (node.left != null) {
            printBoundaryRight(node.left);
            //System.out.print(node.data + " ");
            list.add(node.val);
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    // A function to do boundary traversal of a given binary tree
    void printBoundary(TreeNode node)
    {
        if (node == null)
            return;

        //System.out.print(node.data + " ");
        list.add(node.val);

        // Print the left boundary in top-down manner.
        printBoundaryLeft(node.left);

        // Print all leaf nodes
        printLeaves(node.left);
        printLeaves(node.right);

        // Print the right boundary in bottom-up manner
        printBoundaryRight(node.right);
    }
}

public class BoundaryofBinaryTree {
    public static void boundaryOfBinaryTree() {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right = new TreeNode(22);
        root.right.right = new TreeNode(25);

        BinaryTree tree = new BinaryTree(root);
        tree.printBoundary(tree.root);

        List<Integer> l = tree.list;
        System.out.println(">>>>>>>>>>>>>>");
        //tree.printBoundaryLeft(tree.root);
        //tree.printBoundaryRight(tree.root);
    }
}

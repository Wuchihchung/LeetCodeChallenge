package com.leetcode.bryan.medium;

import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersinEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect() {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);
        n.next = null;

        n.left.left = new Node(4);
        n.left.right = new Node(5);
        n.left.next = null;

        n.right.left = new Node(6);
        n.right.right = new Node(7);
        n.right.next = null;

        n.left.left.left = null;
        n.left.left.right = null;
        n.left.left.next = null;

        n.left.right.left = null;
        n.left.right.right = null;
        n.left.right.next = null;

        n.right.left.left = null;
        n.right.left.right = null;
        n.right.left.next = null;

        n.right.right.left = null;
        n.right.right.right = null;
        n.right.right.next = null;

        List<Node> notes = new ArrayList<>();
        notes.add(n);

        while (true) {
            notes = populatePoints(notes);
            if (notes.size() == 0) break;
            System.out.println(">>>");
        }

        return n;
    }

    private static List<Node> populatePoints(List<Node> notes) {
        int size = notes.size();
        List<Node> notesNext = new ArrayList<>();

        if (size == 1) {
            if (notes.get(0).left != null) notesNext.add(notes.get(0).left);
            if (notes.get(0).right != null) notesNext.add(notes.get(0).right);

            return notesNext;
        }

        for (int i = 0; i < size; i++) {
            Node prenode = notes.get(i);
            Node nextnode;

            if (i + 1 < size) {
                nextnode = notes.get(i + 1);
                prenode.next = nextnode;
            }

            if (prenode.left != null) notesNext.add(prenode.left);
            if (prenode.right != null) notesNext.add(prenode.right);
        }

        return notesNext;
    }
}

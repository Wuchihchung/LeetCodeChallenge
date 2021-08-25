package com.leetcode.bryan.hard;

import java.util.*;


public class SerializeandDeserializeNaryTree {
    Node root;

    public SerializeandDeserializeNaryTree() {
        Node n1 = new Node(5, null);
        Node n2 = new Node(6, null);
        List<Node> list1 = new ArrayList<>();
        list1.add(n1);
        list1.add(n2);
        Node n3 = new Node(333323, list1);
        Node n4 = new Node(111112, null);

        Node n6 = new Node(9, null);
        List<Node> list3 = new ArrayList<>();
        list3.add(n6);
        Node n5 = new Node(4, list3);

        List<Node> list2 = new ArrayList<>();
        list2.add(n3);
        list2.add(n4);
        list2.add(n5);
        root = new Node(1, list2);
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public String serialize() {
        if (root == null)
            return "#";

        StringBuilder sb = new StringBuilder("");
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        sb.append(root.val + "$#");

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.children != null) {
                for (Node n : node.children) {
                    sb.append(n.val + "$");
                    queue.add(n);
                }
            }

            sb.append("#");
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.equals("#"))
            return null;

        Node dummyRoot = new Node(-1, new ArrayList<>());
        Queue<Node> queue = new LinkedList<>();
        queue.add(dummyRoot);
        int index = 0;

        while (!queue.isEmpty() && index < data.length()) {
            Node node = queue.poll();

            while (data.charAt(index) != '#') {
                int value = 0;

                while (data.charAt(index) != '$') {
                    value = value * 10 + Integer.parseInt(String.valueOf(data.charAt(index++)));
                }

                index++;
                Node newNode = new Node(value, new ArrayList<>());
                node.children.add(newNode);
                queue.add(newNode);
            }

            index++;
        }

        return dummyRoot.children.get(0);
    }
}

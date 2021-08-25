package com.leetcode.bryan.medium;

import java.util.*;


public class CopyListwithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node point1 = head, point2 = head;
        List<Node> newNodes = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int index = 0;
        while (point1 != null) {
            newNodes.add(new Node(point1.val));

            if (point1.random == null)
                map.put(index, -1);
            else {
                int val = point1.random.val;
                map.put(index, getInedex(point2, val));
            }

            point1 = point1.next;
        }

        index = 0;
        int size = newNodes.size();

        for (int i = 0; i < size - 1; i++) {
            Node node = newNodes.get(index);
            Node nodeNext = newNodes.get(index + 1);
            node.next = nodeNext;

            int idx = map.get(index);
            if (idx == -1)
                node.random = null;
            else
                node.random = newNodes.get(idx);
        }

        newNodes.get(size - 1).next = null;

        return newNodes.get(0);
    }

    private int getInedex(Node node, int value) {
        Node dummy = node;
        int index = 0;

        while (dummy != null) {
            if (dummy.val == value) return index;

            dummy = dummy.next;
            index++;
        }

        return -1;
    }
}

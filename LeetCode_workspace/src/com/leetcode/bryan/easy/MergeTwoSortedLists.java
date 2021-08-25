package com.leetcode.bryan.easy;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode node = new ListNode();
        ListNode point = node;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.val = l2.val;
                l2 = l2.next;
            } else {
                node.val = l1.val;
                l1 = l1.next;
            }

            if (l1 != null && l2 != null) {
                node.next = new ListNode(999);
                node = node.next;
            }
        }

        if (l1 != null) {
            node.next = l1;
        } else if (l2 != null) {
            node.next = l2;
        }

        return point;
    }
}

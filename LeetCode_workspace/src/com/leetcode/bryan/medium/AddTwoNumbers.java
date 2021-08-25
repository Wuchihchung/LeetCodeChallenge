package com.leetcode.bryan.medium;

/**
 * https://leetcode.com/problems/add-two-numbers/
 *
 * 1. 相加後注意進位
 * 2. 最後最部加完後要再看有沒有多一位進位的
 *
 */

public class AddTwoNumbers {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode point = dummy;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int val1 = 0;
            int val2 = 0;

            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }

            int result = val1 + val2 + carry;
            carry = result / 10;

            point.next = new ListNode(result % 10);
            point = point.next;
        }

        if (carry == 1) point.next = new ListNode(1);

        return dummy.next;
    }
}

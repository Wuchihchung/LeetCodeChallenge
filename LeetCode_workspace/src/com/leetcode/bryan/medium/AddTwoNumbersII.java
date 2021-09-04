package com.leetcode.bryan.medium;

import com.leetcode.bryan.common.ListNode;

import java.util.Stack;

/**
 * Amazon
 * https://leetcode.com/problems/add-two-numbers-ii/
 *
 * Time : O()
 */

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode point = new ListNode(-1);
        int carry = 0;

        while (!s1.empty() || !s2.empty()) {
            int val1 = 0;
            int val2 = 0;

            if (!s1.empty()) val1 = s1.pop();
            if (!s2.empty()) val2 = s2.pop();

            int result = val1 + val2 + carry;
            carry = result / 10;

            ListNode node = new ListNode(result % 10);
            if (point.next == null) point.next = node;
            else {
                node.next = point.next;
                point.next = node;
            }
        }

        if (carry == 1) {
            ListNode node = new ListNode(1);

            node.next = point.next;
            point.next = node;
        }

        return point.next;
    }
}
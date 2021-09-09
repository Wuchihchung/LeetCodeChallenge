package com.leetcode.bryan.easy;

import com.leetcode.bryan.common.ListNode;


/**
 * https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3966/
 */

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode end = new ListNode(head.val);
        ListNode pre = new ListNode(-1);
        pre.next = end;

        head = head.next;
        while (head != null) {
            ListNode cur = new ListNode(head.val);
            cur.next = pre.next;
            pre.next = cur;

            head = head.next;
        }

        return pre.next;
    }
}
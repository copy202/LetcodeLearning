package com.leetcode.learning.q24;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode left = head, right = head.next;
        ListNode next = right.next;

        right.next = left;
        left.next = swapPairs(next);
        return right;
    }
}

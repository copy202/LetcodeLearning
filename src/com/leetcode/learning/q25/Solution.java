package com.leetcode.learning.q25;

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==0 || k==1) return head;
        if(!checkLength(head, k)) return head;
        ListNode left = head, right = head.next;
        ListNode tail =null,next = right.next;
        for (int i = 0; i < k-1; i++) {
            if(left == head) {
                left.next = null;
                tail = left;
            }
            right.next = left;
            left = right;
            right = next;
            next = next == null? null : next.next;
        }

        tail.next = reverseKGroup(right, k);

        return left;
    }

    private boolean checkLength(ListNode head, int length) {
        if(head == null) {
            return false;
        }
        ListNode checkPoint = head;
        while (length-- > 1){
            checkPoint = checkPoint.next;
            if(checkPoint == null) {
                return false;
            }
        }

        return true;
    }

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

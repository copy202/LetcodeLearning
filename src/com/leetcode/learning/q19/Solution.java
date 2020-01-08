package com.leetcode.learning.q19;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode deleted = head, tailed = deleted;
        for (int i = 0; i < n; i++) {
            tailed = tailed.next;
        }
        boolean flag = false;
        ListNode left = head;
        while (tailed.next != null){
            if(flag)
                left=left.next;
            else
                flag=true;
            deleted = deleted.next;
            tailed = tailed.next;
        }

        if(left == deleted){
            head=head.next;
        }else {
            left.next = deleted.next;
            deleted.next = null;
        }

        return head;
    }
}

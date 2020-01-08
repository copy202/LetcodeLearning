package com.leetcode.learning.q206;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        return swap(head, null);
    }

    private ListNode swap(ListNode cur, ListNode last){

        ListNode next = cur.next;
        cur.next = last;
        last = cur;

        if(next == null){
            return cur;
        } else {
            return swap(next, last);
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        //listNode1.next = listNode2;
        //listNode2.next = listNode3;

        new Solution().reverseList(listNode1);
    }
}

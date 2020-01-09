package com.leetcode.learning.q21;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        ListNode head = null;
        ListNode cur = null;
        ListNode merged;

        do {

            if(l1.val <= l2.val){
                merged = l1;
                l1 = l1.next;
            }else{
                merged = l2;
                l2 = l2.next;
            }
            merged.next = null;
            if(head == null) {
                head = merged;
                cur = head;
            } else {
                cur.next = merged;
                cur = cur.next;
            }

        } while (l1 != null && l2 != null);

        if(l1!=null){
            cur.next = l1;
        }

        if(l2!=null){
            cur.next = l2;
        }

        return head;
    }

    public static void main(String[] args) {

    }

}

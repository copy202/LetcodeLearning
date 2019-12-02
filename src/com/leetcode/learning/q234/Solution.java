package com.leetcode.learning.q234;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(null == head){
            return true;
        }
        ListNode tmp = head;
        int length = 0;
        do {
            length++;
            tmp = tmp.next;
        }while (null != tmp);

        if(length == 1){
            return true;
        }

        int leftCount = length /2;

        ListNode leftNode = null, rightNode = null;
        ListNode cur = head;
        do {
            rightNode = cur.next;
            cur.next = leftNode;
            leftNode = cur;
            cur = rightNode;
        } while (--leftCount > 0);
        ListNode headL = leftNode;

        if(length % 2 > 0){
            cur = cur.next;
        }
        ListNode headR = cur;

        do {
            if(headL.val != headR.val){
                return false;
            }

            headR = headR.next;
            headL = headL.next;
        }while (null != headR);

        //System.out.println("xxx");
        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Solution solution = new Solution();
        solution.isPalindrome(node1);

    }
}

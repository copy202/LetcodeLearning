package com.leetcode.learning.q817;

import java.util.*;

public class Solution {
    public int numComponents(ListNode head, int[] G) {

        if (head == null || G.length == 0){
            return 0;
        }

        Map<Integer, Integer> counterMap = new HashMap<>();
        for (int i = 0; i < G.length; i++) {
            counterMap.putIfAbsent(Integer.valueOf(G[i]), Integer.valueOf(0));
            counterMap.compute(Integer.valueOf(G[i]), (k, v) -> Integer.valueOf(v.intValue() + 1));
        }

        boolean isStarted = false;
        int result = 0;
        do {

            if(counterMap.containsKey(Integer.valueOf(head.val))){
                Integer count = counterMap.get(Integer.valueOf(head.val));
                isStarted = true;
                count--;
                if(count <=0){
                    counterMap.remove(Integer.valueOf(head.val));
                } else {
                    counterMap.put(Integer.valueOf(head.val), Integer.valueOf(count));
                }
            }else{
                if(isStarted){
                    result++;
                }
                isStarted = false;
            }
            head = head.next;
        } while (head != null);
        if(isStarted){
            result++;
        }
        return result;
    }


    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        new Solution().numComponents(listNode0, new int[]{0,2,4});
    }
}

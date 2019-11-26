package com.leetcode.learning.q23;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null,cur = null;

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val > o2.val){
                    return 1;
                } else if(o1.val < o2.val){
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if(null != lists[i]) {
                pq.offer(lists[i]);
            }
        }

        while(pq.iterator().hasNext()){
            ListNode node = pq.poll();
            if(null == result){
                result = new ListNode(node.val);
                cur = result;
            } else {
                cur.next = new ListNode(node.val);
                cur = cur.next;
            }
            //System.out.println(node.val+"->");
            if(null != node.next){
                pq.offer(node.next);
            }
        }

        return result;
    }
}

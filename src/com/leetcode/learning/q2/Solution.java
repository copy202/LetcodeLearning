package com.leetcode.learning.q2;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret  = new ListNode(0);
        ListNode p1 = l1,p2=l2,p=ret;
        boolean flag = false;

        while(true){
            int tmp = 0;

            if(p1 == null && p2==null && flag==false){
                //结束标志
                break;
            }
            ListNode tmpNode = new ListNode(0);

            if(p1!=null){
                tmp = tmp + p1.val;
            }
            if(p2!=null){
                tmp = tmp + p2.val;
            }

            if(flag){
                tmp = tmp + 1;
                flag = false;
            }

            if(tmp >=10){
                tmp  = tmp - 10;
                flag = true;
            }

            tmpNode.val = tmp;
            p.next = tmpNode;
            p = p.next;

            if(p1!=null){
                p1 = p1.next;
            }
            if(p2!=null){
                p2 = p2.next;
            }

        }


        return ret.next;
    }
}

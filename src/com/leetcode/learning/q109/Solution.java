package com.leetcode.learning.q109;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(null == head){
            return null;
        }
        int countNode = 0;
        List<Integer> nodeListValue = new ArrayList<>();

        ListNode curNode = head;
        while (null != curNode){
            nodeListValue.add(curNode.val);
            countNode++;
            curNode = curNode.next;
        }


        TreeNode result = balance(nodeListValue, 0, countNode - 1);

        return result;
    }


    private TreeNode balance(List<Integer> nodeListValue, int left, int right){
        if(left<=right){
            int middle = (left + right)/2;
            TreeNode tmp = new TreeNode(nodeListValue.get(middle));
            tmp.left = balance(nodeListValue, left, middle-1);
            tmp.right = balance(nodeListValue, middle+1, right);
            return tmp;
        }
        return null;
    }
}

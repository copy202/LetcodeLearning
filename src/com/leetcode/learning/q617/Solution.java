package com.leetcode.learning.q617;

public class Solution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if(null == t1 && null == t2){
            return null;
        }

        int value = null == t1 ? 0 : t1.val;
        value += null == t2 ? 0 : t2.val;

        TreeNode head = new TreeNode(value);
        head.left = mergeTrees(null == t1? null : t1.left, null == t2 ? null : t2.left);
        head.right = mergeTrees(null == t1? null : t1.right, null == t2 ? null : t2.right);

        return head;
    }
}

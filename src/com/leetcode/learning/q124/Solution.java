package com.leetcode.learning.q124;

public class Solution {
    private int max = 0;

    public int maxPathSum(TreeNode root) {
        if (null == root){
            return 0;
        }
        max = root.val;
        int x = callTreeNodeSum(root);

        return Math.max(x, max);
    }

    private int callTreeNodeSum(TreeNode root) {

        int cur = root.val;
        int leftMax = 0, rightMax = 0;
        boolean leftCompare = false, rightCompare =false;
        if (null != root.left){
            leftCompare = true;
            leftMax = callTreeNodeSum(root.left);
        }
        if (null != root.right){
            rightCompare = true;
            rightMax = callTreeNodeSum(root.right);
        }

        //非传递max记录
        int nocall = leftMax + rightMax + cur;
        max = Math.max(nocall, max);
        if (leftCompare) {
            max = Math.max(leftMax, max);
        }
        if (rightCompare) {
            max = Math.max(rightMax, max);
        }

        int call = Math.max(leftMax + cur, cur);
        call = Math.max(rightMax + cur, call);

        return call;
    }
}

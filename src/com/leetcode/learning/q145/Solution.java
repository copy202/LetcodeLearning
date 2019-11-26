package com.leetcode.learning.q145;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (null == root) {
            return Arrays.asList();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur;
        st.push(root);
        while (!st.isEmpty()) {
            cur = st.pop();
            if(cur.left != null || cur.right != null) {
                TreeNode cleft = cur.left;
                TreeNode cright = cur.right;
                cur.left = null;
                cur.right = null;
                st.push(cur);
                if (cright != null) {
                    st.push(cright);
                }
                if (cleft != null) {
                    st.push(cleft);
                }

            } else {
                result.add(cur.val);
            }
        }

        return result;
    }
}

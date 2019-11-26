package com.leetcode.learning.q113;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> ret = new LinkedList<>();

        if(null == root){
            //over
            return ret;
        }

        if(null == root.left && null == root.right){
            if(root.val == sum) {
                LinkedList<Integer> t = new LinkedList<>();
                t.add(root.val);
                ret.add(t);
            }
            return ret;
        }

        if(null != root.left){
            List<List<Integer>> temp = pathSum(root.left, sum-root.val);
            if(null != temp && temp.size() > 0){
                for(List<Integer> s: temp){
                    s.add(0, root.val);
                    ret.add(s);
                }
            }
        }
        if(null != root.right){
            List<List<Integer>> temp = pathSum(root.right, sum-root.val);
            if(null != temp && temp.size() > 0){
                for(List<Integer> s: temp){
                    s.add(0, root.val);
                    ret.add(s);
                }
            }
        }

        return ret;
    }
}

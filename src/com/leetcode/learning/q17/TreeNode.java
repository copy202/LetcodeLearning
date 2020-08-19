package com.leetcode.learning.q17;

import java.util.List;

public class TreeNode<T> {
    T val;
    List<TreeNode<T>> childs;
    TreeNode<T> next;

    TreeNode(T x) {
        val = x;
    }
}
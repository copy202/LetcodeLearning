package com.leetcode.learning.q491;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        //使用位图法，如果1表示选中，0表示未选中。至少要2个1才能表示子序列
        //题目中约束，给定的数组不超过15，java中长度为16的类型是short
        short cal = 0;

        for (int i = 0; i < len; i++) {
        }

        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findSubsequences(new int[]{5, 2, 4, 1, 7, 4, 1, 2, 1});
    }
}

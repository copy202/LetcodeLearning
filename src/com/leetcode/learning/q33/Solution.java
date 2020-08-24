package com.leetcode.learning.q33;

public class Solution {
    public int search(int[] nums, int target) {
        return handle(nums, 0, nums.length - 1, target);
    }

    private int handle(int[] nums, int start, int end, int target) {
        int len = end - start;
        if (len == 0) {
            if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        } else {
            if (nums[start] < nums[end]) {
                if (target < nums[start] || target > nums[end]) {
                    return -1;
                }
            }
            int left = handle(nums, start, (end - start) / 2 + start, target);
            int right = handle(nums, (end - start) / 2 + start + 1, end, target);
            if (left > -1) {
                return left;
            } else if (right > -1) {
                return right;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4, 5, 6, 2, 3}, 2) == 3 ? true : false);
        System.out.println(solution.search(new int[]{4, 5, 6, 2, 3}, 7) == -1 ? true : false);
        System.out.println(solution.search(new int[]{4, 5, 6, 2, 3}, 5) == 1 ? true : false);
        System.out.println(solution.search(new int[]{4, 5, 6, 2, 3}, 0) == -1 ? true : false);
    }
}

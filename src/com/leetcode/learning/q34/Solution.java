package com.leetcode.learning.q34;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        return handle(nums, 0, nums.length - 1, target);
    }

    private int[] handle(int[] nums, int start, int end, int target) {
        int len = end - start;
        if (len < 0) {
            return new int[]{-1, -1};
        } else if (len == 0) {
            if (nums[start] == target) {
                return new int[]{start, start};
            } else {
                return new int[]{-1, -1};
            }
        } else {
            if (target < nums[start] || target > nums[end]) {
                return new int[]{-1, -1};
            } else {
                int[] left = handle(nums, start, (end - start) / 2 + start, target);
                int[] right = handle(nums, (end - start) / 2 + start + 1, end, target);
                int leftValue = getSuiteValue(left, false);
                int rightValue = getSuiteValue(right, true);
                if (leftValue == -1) {
                    return right;
                } else if (rightValue == -1) {
                    return left;
                } else {
                    return new int[]{leftValue, rightValue};
                }
            }
        }
    }

    private int getSuiteValue(int[] data, boolean forward) {
        if (data[0] == data[1]) {
            return data[0];
        } else {
            if (data[0] == -1) {
                return data[1];
            } else {
                if (forward) {
                    return data[1];
                } else {
                    return data[0];
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.searchRange(new int[]{}, 0);
        int[] res = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 7);
        System.out.println("hello");
    }
}

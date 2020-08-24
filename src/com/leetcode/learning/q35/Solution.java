package com.leetcode.learning.q35;

public class Solution {

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] > target) {
                return i;
            }
        }
        return nums.length;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.searchInsert(new int[]{2, 3, 4, 6, 7}, 1));
        System.out.println(solution.searchInsert(new int[]{2, 3, 4, 6, 7}, 8));
        System.out.println(solution.searchInsert(new int[]{2, 3, 4, 6, 7}, 4));
        System.out.println(solution.searchInsert(new int[]{2, 3, 4, 6, 7}, 5));
    }
}

package com.leetcode.learning.q80;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int res = nums.length;
        int MAX_REPEAT = 1, curRepeat = 0;
        int pos = -1;
        boolean isValid = false;
        for (int i = 1; i < nums.length; i++) {
            isValid = false;
            if(nums[i-1] == nums[i]){
                if(curRepeat < MAX_REPEAT){
                    curRepeat++;
                    isValid = true;
                } else {
                    res--;
                    pos = pos < 0 ? i : pos;
                }

            } else {
                curRepeat = 0;
                isValid = true;
            }

            if(isValid && pos > 0) {
                nums[pos] = nums[i];
                pos ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(new int[]{1,1,1,2,2,3}));
        System.out.println(solution.removeDuplicates(new int[]{-1,0,0,0,0,3,3}));
        System.out.println(solution.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}

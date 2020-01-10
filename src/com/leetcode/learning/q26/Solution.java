package com.leetcode.learning.q26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int res = nums.length;
        int pos = -1;
        for (int i = 1; i < nums.length; i++) {
            if( nums[i-1] == nums[i]){
                res--;
                pos = pos < 0 ? i : pos;
            } else {
                if(pos > 0) {
                    nums[pos] = nums[i];
                    pos ++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.removeDuplicates(new int[]{1,1,2}));
        System.out.println(solution.removeDuplicates(new int[]{-1,0,0,0,0,3,3}));
    }
}

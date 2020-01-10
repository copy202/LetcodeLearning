package com.leetcode.learning.q27;

public class Solution {

    public int removeElement(int[] nums, int val) {
        int res = nums.length;
        int pos = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == val){
                res--;
                pos = pos < 0 ? i : pos;
            } else {
                if(pos >= 0) {
                    nums[pos] = nums[i];
                    pos ++;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeElement(new int[]{3,2,2,3}, 3));
//        System.out.println(solution.removeElement(new int[]{-1,0,0,0,0,3,3}, 3));
//        System.out.println(solution.removeElement(new int[]{0,0,1,1,1,1,2,3,3}, 1));
    }
}

package com.leetcode.learning.q15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length < 3 || nums[0] > 0 || nums[nums.length -1] <0){
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            if(i - 1 >= 0 && nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] > 0){
                break;
            }

            int flag = nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right){
                if(flag + nums[left] + nums[right] == 0){
                    result.add(Arrays.asList(flag, nums[left], nums[right]));
                    while (right - 1 > 0 && nums[right -1] == nums[right]) right--;
                    while (left + 1 < nums.length && nums[left + 1] == nums[left]) left++;
                    left ++;
                    right--;

                } else if(flag + nums[left] + nums[right] > 0){
                    right--;
                } else if(flag + nums[left] + nums[right] < 0){
                    left++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.threeSum(new int[]{0,0,0,0});
    }
}

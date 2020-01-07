package com.leetcode.learning.q18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length < 4){
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            if(i - 1 >= 0 && nums[i] == nums[i-1]){
                continue;
            }

            if(nums.length - i < 3){
                break;
            }

            List<List<Integer>> threeSum = threeSum(nums, target - nums[i], i + 1);
            if(!threeSum.isEmpty()){
                for (int j = 0; j < threeSum.size(); j++) {
                    result.add(Arrays.asList(nums[i], threeSum.get(j).get(0), threeSum.get(j).get(1), threeSum.get(j).get(2)));
                }
            }
        }
        return result;
    }

    private List<List<Integer>> threeSum(int[] nums, int target, int start) {

        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3){
            return result;
        }

        for (int i = start; i < nums.length; i++) {
            if(i - 1 >= start && nums[i] == nums[i-1]){
                continue;
            }

            int flag = nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right){
                if(flag + nums[left] + nums[right] == target){
                    result.add(Arrays.asList(flag, nums[left], nums[right]));
                    while (right - 1 > start && nums[right -1] == nums[right]) right--;
                    while (left + 1 < nums.length && nums[left + 1] == nums[left]) left++;
                    left ++;
                    right--;

                } else if(flag + nums[left] + nums[right] > target){
                    right--;
                } else if(flag + nums[left] + nums[right] < target){
                    left++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11);
    }
}

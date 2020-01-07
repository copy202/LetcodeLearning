package com.leetcode.learning.q16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        if(nums.length < 3){
            return 0;
        }

        int cur = nums[0]+nums[1]+nums[2];
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if(i - 1 >= 0 && nums[i] == nums[i-1]){
                continue;
            }

            int flag = nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right){
                int t = flag + nums[left] + nums[right];
                if(Math.abs(t-target) < Math.abs(cur - target)){
                    cur = t;
                }
                if(t == target){
                    return target;
                } else if(t  > target){
                    right--;
                } else if(t  < target){
                    left++;
                }
            }
        }

        return cur;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.threeSumClosest(new int[]{-3,-2,-5,3,-4}, -1);
    }
}

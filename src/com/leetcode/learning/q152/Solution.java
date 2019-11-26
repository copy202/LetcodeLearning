package com.leetcode.learning.q152;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int maxProduct(int[] nums) {
        if (null == nums || nums.length == 0) {
            System.err.println("The array nums has no elements");
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }

        int result = nums[0];

        List<Integer> zeroIndex = new ArrayList<>();


        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                zeroIndex.add(i);
            }
        }

        if(zeroIndex.size() > 0){
            int start = 0;
            for (int i = 0; i < zeroIndex.size(); i++) {
                result = Math.max(result, findMax(nums, start, zeroIndex.get(i)-1));
                start = zeroIndex.get(i) + 1;
            }
            result = Math.max(result, findMax(nums, start, nums.length - 1));
        }else{
            result = findMax(nums, 0, nums.length - 1);
        }

        return result;
    }

    private int findMax(int[] nums, int start, int end) {
        if(end < start){
            return 0;
        }
        List<Integer> negativeIndex = new ArrayList<>();
        for (int i = start; i <=end  ; i++) {
            if(nums[i] < 0){
                negativeIndex.add(i);
            }
        }
        int result = nums[start];
        if (!negativeIndex.isEmpty() && negativeIndex.size()%2!=0){
            result = Math.max(calculate(nums, start,negativeIndex.get(negativeIndex.size()-1) -1),result);
            result = Math.max(calculate(nums, negativeIndex.get(0)+1, end),result);
        }else {
            result = calculate(nums, start, end);
        }
        return result;
    }

    private int calculate(int[] nums, int start, int end) {
        if(end < start){
            return 0;
        }
        int result = nums[start];
        for (int i = start + 1; i <= end; i++) {
            result *= nums[i];
        }
        return result;
    }
}

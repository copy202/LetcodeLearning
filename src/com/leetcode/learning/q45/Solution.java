package com.leetcode.learning.q45;

public class Solution {
    private int[][] store;

    public int jump(int[] nums) {
        //
        if(null ==nums || nums.length<=1){
            return 0;
        }
        //init(nums);
        return jump3(nums,0,nums.length-1);
    }

    private void init(int[] nums){
        if (nums.length > 0) {
            store = new int[nums.length][nums.length];
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if(j<=nums[i] && j>0){
                        store[i][j] = 1;
                    }else {
                        store[i][j] = -2; //flag -2
                    }
                }
            }
        }
    }

    private int jump2(int[] nums, int startIndex, int jumpSteps){

        System.out.println("calulate: "+startIndex+"  "+ jumpSteps);

        if(jumpSteps <= 0){
            return 0;
        }

        if(nums[startIndex] >= jumpSteps){
            return 1;
        }

        if(startIndex == nums.length-1 && nums[startIndex] < jumpSteps){
            return 0;
        }

        int min = -1;

        if(nums[startIndex]==0 && jumpSteps > 0){
            return -1;
        }

        if(store[startIndex][jumpSteps] != -2){
            return store[startIndex][jumpSteps];
        }

        if(nums[startIndex] == 1){
            if(store[startIndex+1][jumpSteps-1] != -2){
                return 1+store[startIndex+1][jumpSteps-1];
            }else {
                return 1 + jump2(nums, startIndex + 1, jumpSteps - 1);
            }
        }

        for(int i=1;i<=nums[startIndex];i++){

            int left = store[startIndex][i]==-2?jump2(nums, startIndex, i):store[startIndex][i];
            int right = store[startIndex+i][jumpSteps-i]==-2?jump2(nums, startIndex+i, jumpSteps-i):store[startIndex+i][jumpSteps-i];
            if(left<0 || right<0){
                continue;
            }
            int cur = left+right;
            if(min <0){
                min = cur;
            }else{
                if(cur<min){
                    min = cur;
                }
            }
        }

        store[startIndex][jumpSteps]=min;
        return min;
    }

    private int jump3(int[] nums, int startIndex, int jumpSteps){
        if(nums.length <= 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length -1;) {
            if(i+nums[i] >= nums.length -1){
                count ++;
                break;
            }
            int zero = i + nums[i];
            for(int j=i + nums[i];j>i;j--){
                if(nums[zero] > 0){
                    break;
                }
                zero -- ;
            }
            int next = findMax(nums, i, zero);
            if(next == i || next == i+nums[i]){
                i=i+nums[i];
            }else{
                i=next;
            }
            count ++;
        }
        return count;
    }

    private int findMax(int[] nums, int startIndex ,int endIndex){
        //探测
        int result = startIndex;
        int max = nums[startIndex];
        for (int i = startIndex + 1; i <=endIndex; i++) {
            if(nums[i] + (i-startIndex) > max){
                result = i;
                max = nums[i] + (i-startIndex);
            }
        }
        return result;
    }

    private int jump4(int[] nums) {
        if (nums.length == 1) {return 0;};
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j > 0; j--) {
                if (i + j >= nums.length - 1) {
                    return dp[i] + 1;
                } else if (dp[i + j] == 0) {
                    dp[i + j] = dp[i] + 1;
                } else {
                    break;
                }
            }
        }
        return 0;
    }
}

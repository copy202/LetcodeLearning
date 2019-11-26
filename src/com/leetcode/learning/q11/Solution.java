package com.leetcode.learning.q11;

public class Solution {
    public int maxArea(int[] height) {

        int n = height.length;
        if(n<=1){
            return 0;
        }

        return func1(height, 1, n);
    }

    private int func1(int[] height, int i, int j){
        if(i==j){
            return 0;
        }
        if(j-i==1){
            return cal(height, i, i+1);
        }
        int tmp = func1(height, i, j-1);
        for(int x=i;x<j;x++){
            int y=cal(height, x, j);
            if(y>tmp){
                tmp = y;
            }
        }
        return tmp;
    }

    private int cal(int[] height, int i, int j){
        return Math.min(height[i-1],height[j-1])*(j-i);
    }
}

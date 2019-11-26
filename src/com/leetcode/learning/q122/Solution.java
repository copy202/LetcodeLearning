package com.leetcode.learning.q122;

public class Solution {
    public int maxProfit(int[] prices) {
        if(null == prices || prices.length < 2){
            return 0;
        }

        int result = 0;

        boolean isClose = false;
        int startNum=0;
        for (int i = 0; i < prices.length - 1; i++) {
            if(prices[i+1] - prices[i] > 0){
                if(!isClose){
                    startNum = prices[i];
                }
                isClose = true;
            } else if(prices[i+1] - prices[i] < 0) {
                if(isClose){
                    result+= prices[i] - startNum;
                    startNum = 0;
                }
                isClose = false;
            }
        }
        if (isClose){
            result+= prices[prices.length-1] - startNum;
        }

        return result;
    }
}

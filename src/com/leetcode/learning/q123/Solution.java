package com.leetcode.learning.q123;

public class Solution {
    public int maxProfit(int[] prices) {
        if(null == prices || prices.length < 2){
            return 0;
        }
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            result = Math.max(result, maxSubProfit(prices, 0, i-1) + maxSubProfit(prices, i, prices.length - 1));
        }
        return result;
    }

    private int maxSubProfit(int[] prices, int startIndex, int endIndex) {
        if(null == prices){
            return 0;
        }
        if(endIndex - startIndex < 1) {
            return 0;
        }

        int result = 0;

        for (int i = startIndex; i < endIndex; i++) {
            if(prices[i+1] <= prices[i]){
                continue;
            }
            for (int j = i+1; j <= endIndex; j++) {
                if(j+1 <= endIndex && prices[j+1] >= prices[j]){
                    continue;
                }
                result = Math.max(result, prices[j] - prices[i]);
            }
        }

        return Math.max(0, result);
    }
}

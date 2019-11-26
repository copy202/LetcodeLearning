package com.leetcode.learning.q121;

public class Solution {
    public int maxProfit(int[] prices) {
        if(null == prices || prices.length < 2){
            return 0;
        }

        int result = prices[1] - prices[0];

        for (int i = 0; i < prices.length - 1; i++) {
            if(prices[i+1] <= prices[i]){
                continue;
            }
            for (int j = i+1; j < prices.length; j++) {
                if(j+1 <= prices.length-1 && prices[j+1] >= prices[j]){
                    continue;
                }
                result = Math.max(result, prices[j] - prices[i]);
            }
        }

        return Math.max(0, result);
    }
}

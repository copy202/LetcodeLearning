package com.leetcode.learning.q29;

import java.util.Map;

public class Solution {
    public int divide(int dividend, int divisor) {

        int res = 0;

        if(dividend == 0) {
            return res;
        }

        if(divisor == -1 && dividend ==Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        boolean isPositive = (dividend > 0 ? true: false) == (divisor > 0 ? true :false) ? true :false;
        dividend = dividend > 0? -1*dividend : dividend;
        divisor = divisor > 0? -1*divisor : divisor;

        int speed = 1;
        while (dividend <= divisor){
             if(dividend <= speed * divisor){
                 res += speed;
                 dividend = dividend - speed * divisor;
                 speed = speed << 1;
             }else {
                 speed = speed >>> 1;
             }
        }

        return isPositive ? res :  -1*res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(-2147483648, -1));
        System.out.println(solution.divide(2147483647, -1));
        System.out.println(solution.divide(-2147483648, 2));
        System.out.println(solution.divide(Integer.MAX_VALUE, -2147483648));

    }
}

package com.leetcode.learning.q7;

public class Solution {
    public int reverse(int x) {
        if(x == 0){
            return 0;
        }
        boolean isNagtive = x > 0? false:true;
        int value = Math.abs(x);
        Long tmp = 0L;
        for (;value>0;){

            int g = value%10;
            tmp = tmp*10 + g;
            if(isNagtive && ((-1*tmp) < Integer.MIN_VALUE)){
                return 0;
            }else if(!isNagtive && tmp > Integer.MAX_VALUE){
                return 0;
            }
            value = value /10;
        }
        return isNagtive? -1* tmp.intValue():tmp.intValue();
    }
}

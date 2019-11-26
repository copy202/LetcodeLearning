package com.leetcode.learning.q134;

public class Solution {
    private int[] sub;

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int prev = 0;
        sub = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            sub[i] = gas[i] - cost[i];
        }

        for (; prev < gas.length; prev++) {
            if(gas[prev] >= cost[prev] ){
                //try
                if(doTry(prev, gas, cost)){
                    return prev;
                }
            }
        }

        return -1;
    }

    private boolean doTry(int index, int[] gas, int[] cost){
        int haveGas = 0;
        for(int i=0;i < gas.length; i++){
            int cur = (index + i) % gas.length;
            haveGas = haveGas + sub[cur];
            if(haveGas < 0 ){
                return false;
            }
        }
        return true;
    }
}

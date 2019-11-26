package com.leetcode.learning.q780;

public class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (true) {
            if (sx > tx || sy > ty) {
                return false;
            }

            if (sx == tx && sy == ty) {
                return true;
            }else if(sx == tx && sy != ty){
                if((ty - sy)%sx == 0){
                    return true;
                }else {
                    return false;
                }
            }else if(sx != tx && sy == ty){
                if((tx-sx)%sy == 0){
                    return true;
                }else{
                    return false;
                }
            }

            if (tx > ty) {
                tx -= ty;
            } else if (ty > tx){
                ty -= tx;
            } else {
                return false;
            }
        }
    }
}

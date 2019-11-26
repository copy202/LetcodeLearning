package com.leetcode.learning.q3;

import java.util.BitSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if(length==0){
            return 0;
        }else if(length==1){
            return 1;
        }
        int maxLength = 0;
        for(int i=0;i<length;i++){
            BitSet tmp = new BitSet();
            tmp.set((int)s.charAt(i));
            for(int j=i+1;j<length;j++){
                int oldnum = tmp.cardinality();
                tmp.set((int)s.charAt(j));
                int newnum = tmp.cardinality();
                if(oldnum == newnum){
                    //位图法，已经发生了重复
                    //System.out.println("i="+i+",j="+j);
                    break;
                }
                if(maxLength < j-i){
                    maxLength = j-i;
                }
            }


        }
        return maxLength+1;
    }
}

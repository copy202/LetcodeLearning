package com.leetcode.learning.q97;

public class Solution {
    public boolean isInterleave2(String s1, String s2, String s3) {

        if(s1.length() + s2.length() !=  s3.length()){
            return false;
        }

        if(s1.length() == 0){
            return s3.equals(s2);
        }

        if(s2.length() == 0){
            return s3.equals(s1);
        }

        if(s3.length() == 0){
            return true;
        }

        if(s1.charAt(0) == s2.charAt(0) && s1.charAt(0) == s3.charAt(0)){
            return isInterleave2(s1.substring(1), s2, s3.substring(1)) || isInterleave2(s1, s2.substring(1), s3.substring(1));
        }else{
            if(s1.charAt(0) == s3.charAt(0)){
                return isInterleave2(s1.substring(1), s2, s3.substring(1));
            }else if(s2.charAt(0) == s3.charAt(0)){
                return isInterleave2(s1, s2.substring(1), s3.substring(1));
            }else {
                return false;
            }
        }
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() !=  s3.length()){
            return false;
        }

        if(s1.length() == 0){
            return s3.equals(s2);
        }

        if(s2.length() == 0){
            return s3.equals(s1);
        }

        if(s3.length() == 0){
            return true;
        }

        //table[i][j] 表示从s1中取i个，从s2中取j个，与s3中i+j长度比较，如果1表示等于 -1表示不等于
        int[][] table = new int[s1.length() + 1][s2.length() + 1];
        final int MATCH = 1, NOT_MATCH = 0;

        //初始化
        table[0][0] = MATCH;

        //初始化s1
        for (int i = 1; i <= s1.length(); i++) {
            table[i][0] =
                    table[i - 1][0] * (s1.charAt(i - 1) == s3.charAt(i - 1) ? MATCH : NOT_MATCH);
        }

        //初始化s2
        for (int i = 1; i <= s2.length(); i++) {
            table[0][i] =
                    table[0][i - 1] * (s2.charAt(i - 1) == s3.charAt(i - 1) ? MATCH : NOT_MATCH);
        }

        //从s1拿或者从s2拿
        for(int x=1;x<=s1.length();x++){
            for (int y=1;y<=s2.length();y++){
                int getS1 = table[x-1][y] * (s1.charAt(x-1) == s3.charAt( x + y - 1)? MATCH : NOT_MATCH);
                int getS2 = table[x][y-1] * (s2.charAt(y-1) == s3.charAt( x + y - 1)? MATCH : NOT_MATCH);
                table[x][y] = getS1 + getS2 > 0? MATCH : NOT_MATCH;
            }
        }

        return table[s1.length()][s2.length()] == MATCH ? true : false;
    }
}

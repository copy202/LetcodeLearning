package com.leetcode.learning.q931;

public class Solution {
    public int minFallingPathSum(int[][] A) {

        if(A.length == 0) {
            return 0;
        }

        if(A.length == 1){
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < A[0].length; i++) {
                if(A[0][i] < min){
                    min = A[0][i];
                }
            }
            return min;
        }

        int row = A.length, col  = A[0].length;
        int[][] tables = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //first line
                if(i == 0){
                    tables[0][j] = A[0][j];
                }else{
                    int tempMin = tables[i-1][j];
                    if(j > 0){
                        tempMin = Math.min(tempMin, tables[i-1][j-1]);
                    }
                    if(j < col - 1){
                        tempMin = Math.min(tempMin, tables[i-1][j+1]);
                    }
                    tables[i][j] = tempMin + A[i][j];
                }
            }
        }

        int result = tables[row-1][0];
        for (int i = 1; i < col; i++) {
            if (tables[row-1][i]<result){
                result = tables[row-1][i];
            }
        }
        return result;
    }
}

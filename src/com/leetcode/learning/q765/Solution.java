package com.leetcode.learning.q765;

public class Solution {
    public int minSwapsCouples(int[] row) {
        if (null == row || row.length <= 2){
            return 0;
        }

        int result = 0;
        for (int i = 0; i < row.length; i+=2) {
            int target = 0;
            if (row[i] % 2 == 0){
                target = row[i] + 1;
            }else {
                target = row[i] - 1;
            }

            for (int j = i+1; j < row.length; j++) {
                if(target == row[j]){
                    int swap = row[j];
                    row[j] = row[i+1];
                    row[i+1] = swap;
                    if(j!=i+1){
                        result++;
                    }
                }
            }
        }
        return result;
    }
}

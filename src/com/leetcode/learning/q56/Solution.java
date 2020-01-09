package com.leetcode.learning.q56;

import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();


        for (int i = 0; i < intervals.length; i++) {
            int[] tmp = intervals[i];
            boolean isMerged = true;
            Iterator<int[]> iterator = merged.iterator();
            while (iterator.hasNext()) {
                int[] next = iterator.next();

                if(tmp[0]<=next[0] && tmp[1] >= next[1]){
                    iterator.remove();
                } else if(tmp[0]>=next[0] && tmp[1] <= next[1]){
                    isMerged = false;
                } else if(tmp[0]<=next[1] && tmp[1] >= next[1]){
                    tmp[0] = next[0];
                    iterator.remove();
                } else if(tmp[0]<=next[0] && tmp[1] >=next[0]) {
                    tmp[1] = next[1];
                    iterator.remove();
                }
            }
            if(isMerged){
                merged.add(tmp);
            }
        }

        return merged.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][] test= new int[][] {
                {2,3},{4,5},{6,7},{8,9},{1,10}
        };
        Solution solution = new Solution();
        solution.merge(test);
    }
}

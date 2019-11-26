package com.leetcode.learning.q57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(newInterval.length == 0){
            return intervals;
        }
        int[][] tempInterval = Arrays.copyOf(intervals, intervals.length + 1);
        tempInterval[tempInterval.length-1] = newInterval;

        int tmp = -1;

        List<int[]> sorted = Arrays.stream(tempInterval).sorted(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] <= o2[0] ? -1 : 1;
            }
        }).collect(Collectors.toList());

        int flag = -1;
        List<int[]> result = new ArrayList<>();
        result.add(sorted.get(0));
        for (int i=1; i<sorted.size();i++){
            if(sorted.get(i)[0]>result.get(result.size()-1)[1]){
                result.add(sorted.get(i));
            }else {
                result.get(result.size()-1)[1] = Math.max(sorted.get(i)[1], result.get(result.size()-1)[1]);
            }
        }

        return result.toArray(new int[][]{});
    }
}

package com.leetcode.learning.q135;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public int candy(int[] ratings) {

        if(ratings.length == 0) {
            return 0;
        }

        List<AtomicInteger> record = new ArrayList<>();
        int lst = ratings[0];
        int cur = 0;
        int diff = 0;
        record.add(new AtomicInteger(1));
        for(int i=1;i<ratings.length;i++){
            if(ratings[i] > lst){
                diff = 0;
                cur = i;
                record.add(new AtomicInteger(record.get(i-1).get() + 1));
            } else if(ratings[i] <  lst){
                if(record.size()<=cur+1){
                    diff = record.get(cur).get() - 1;
                }else {
                    diff = record.get(cur).get() - record.get(cur + 1).get();
                }
                if(diff < 0){
                    diff = 0;
                }
                int tmp = record.get(i-1).get() - 1;
                if(tmp < 1){
                    for (int j=i-1;j>=cur;j--){
                        if(j==cur && diff-->1){
                            continue;
                        }
                        record.get(j).incrementAndGet();
                    }
                }
                record.add(new AtomicInteger(1));
            } else {
                diff = 0;
                cur = i;
                record.add(new AtomicInteger(1));
            }
            lst  = ratings[i];
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum = sum + record.get(i).get();
        }
        return sum;
    }
}

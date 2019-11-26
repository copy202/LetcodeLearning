package com.leetcode.learning.q793;

public class Solution {

    public int preimageSizeFZF(int K) {
        if(K==0){
            return 5;
        }
        //能产生0的情况只有2*5，那么问题的实质就是有多少2*5成对，所以定义gLast表示2的数量，fLast表示5的数量
        //由于2的数量远远大于5，所以只需要考虑5即可
        int i = 0;
        int sum = 0;

        while (true){
            i += 25;
            int last = cal(i);
            if(sum + 1 == K
                    || sum +2 ==K
                    || sum +3 == K
                    || sum +4 == K
                    || sum +4+ last == K){
                return 5;
            }

            sum = sum + 4 + last;

            if(sum > K){
                return 0;
            }
        }
    }

    private int cal(int target){
        int result=0;
        while (target > 1){
            if(target % 5 == 0) {
                result++;
                target = target / 5;
            }else {
                break;
            }
        }
        return result;
    }
}

package com.leetcode.learning.q22;

import java.util.*;

public class Solution {
    public List<String> generateParenthesis(int n) {
        if(n == 0) {
            return Arrays.asList("");
        }

        if(n == 1){
            return Arrays.asList("()");
        }

        Set<String> hset = new HashSet<>();


        for (int i = 0; i <= n - 1 ; i++) {
            if(i == 0) {
                List<String> tmp = generateParenthesis(n - 1);
                for (int j = 0; j < tmp.size(); j++) {
                    hset.add("()" + tmp.get(j));
                }
            } else {
                List<String> sub1 = generateParenthesis(i);
                List<String> sub2 = generateParenthesis(n - 1 - i);
                for (String s1 : sub1) {
                    for (String s2: sub2) {
                        hset.add("(" + s1 + ")" + s2);
                    }
                }
            }
        }
        return new ArrayList<String>(hset);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.generateParenthesis(4);
        System.out.println();



    }
}

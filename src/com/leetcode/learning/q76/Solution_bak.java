package com.leetcode.learning.q76;

import java.util.HashMap;

public class Solution_bak {
    public String minWindow(String s, String t) {

        if (null == s || s.length() == 0 || null == t || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            targetMap.putIfAbsent(t.charAt(i), Integer.valueOf(0));
            targetMap.compute(t.charAt(i), (k,v)->v+1);
        }

        int min = -1;
        int start = -1;
        for (int i = 0; i < s.length() - t.length() + 1; i++) {
            String sub = s.substring(i);
            int lst = lastIndex(sub, targetMap);
            if (lst >= 0) {
                if (min == -1 || lst + 1 < min) {
                    min = lst + 1;
                    start = i;
                }
            } else if (lst == -2) {
                break;
            }
        }

        if (min >= 0) {
            return s.substring(start, start + min);
        }

        return "";
    }

    private int lastIndex(String s, HashMap<Character, Integer> tMap) {
        if(!tMap.containsKey(s.charAt(0))) {
            return -1;
        }
        HashMap<Character, Integer> targetMap = (HashMap<Character, Integer>) tMap.clone();
        for (int i = 0; i < s.length(); i++) {
            if(targetMap.containsKey(s.charAt(i))){
                targetMap.compute(s.charAt(i), (k,v) -> v-1);
                if(targetMap.get(s.charAt(i)) == 0) {
                    targetMap.remove(s.charAt(i));
                }
            }
            if(targetMap.isEmpty()){
                return i;
            }
        }

        return -2;
    }

    public static void main(String[] args) {
        Solution_bak solution = new Solution_bak();
        System.out.println(solution.minWindow("abcdef", "ae").equals("abcde"));
        System.out.println(solution.minWindow("abcdefa", "ae").equals("efa"));
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC").equals("BANC"));
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABCF").equals(""));
     }
}

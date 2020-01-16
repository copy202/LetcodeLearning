package com.leetcode.learning.q76;

import java.util.HashMap;

public class Solution {

    private HashMap<Character, Integer> curMap;
    private HashMap<Character, Integer> targetMap;

    public String minWindow(String s, String t) {

        curMap = new HashMap<>();
        targetMap = new HashMap<>();

        if (null == s || s.length() == 0 || null == t || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        for (int i = 0; i < t.length(); i++) {
            targetMap.putIfAbsent(t.charAt(i), Integer.valueOf(0));
            targetMap.compute(t.charAt(i), (k,v)->v+1);
        }

        int min = -1;
        int start = -1;
        for (int i = 0; i < s.length() - t.length() + 1; i++) {
            String sub = s.substring(i);
            int lst = findWindow(sub);
            if (lst >= 0) {
                if (min == -1 || lst + 1 < min) {
                    min = lst + 1;
                    start = i;
                }
                break;
            } else if (lst == -2) {
                return "";
            }
        }



        if (min == -1) {
            return "";
        }

        int winLeft = start, winRight = start + min - 1;
        boolean isForward = true;
        while (winLeft < winRight) {
            if(isForward) {
                if (targetMap.containsKey(s.charAt(winLeft))) {
                    curMap.compute(s.charAt(winLeft), (k, v) -> v - 1);
                    winLeft++;
                    if(check()) {
                        if(winRight - winLeft + 1<min){
                            start = winLeft;
                            min = winRight - winLeft + 1;
                        }
                        continue;
                    }
                } else {
                    winLeft++;
                    if(check()) {
                        if(winRight - winLeft + 1<min){
                            start = winLeft;
                            min = winRight - winLeft + 1;
                        }
                    }
                    continue;
                }
            }

                if (winRight + 1 < s.length()) {
                    if (targetMap.containsKey(s.charAt(winRight + 1))) {
                        curMap.compute(s.charAt(winRight + 1), (k, v) -> v + 1);
                        winRight++;
                        if (check()) {
                            if(winRight - winLeft + 1<min){
                                start = winLeft;
                                min = winRight - winLeft + 1;
                            }
                            isForward = true;
                        } else {
                            isForward = false;
                        }
                        continue;
                    } else {
                        isForward = false;
                        winRight++;
                    }
                }

                if (winRight == s.length() - 1) {
                    break;
                }

        }


        return s.substring(start, start + min);
    }

    private int findWindow(String s) {
        if(!targetMap.containsKey(s.charAt(0))) {
            return -1;
        }
        for (int i = 0; i < s.length(); i++) {
            if(targetMap.containsKey(s.charAt(i))){
                curMap.putIfAbsent(s.charAt(i), 0);
                curMap.compute(s.charAt(i), (k,v)->v+1);
            }

            if (check()){
                return i;
            }
        }

        return -2;
    }

    private boolean check() {
        for (Character key : targetMap.keySet()) {
            if (!curMap.containsKey(key) || curMap.get(key) < targetMap.get(key)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("cabwefgewcwaefgcf", "cae").equals("cwae"));
        System.out.println(solution.minWindow("abcdef", "ae").equals("abcde"));
        System.out.println(solution.minWindow("abcdefa", "ae").equals("efa"));
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC").equals("BANC"));
        System.out.println(solution.minWindow("ADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANCADOBECODEBANC", "ABCF").equals(""));
     }
}

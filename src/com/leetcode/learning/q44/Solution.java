package com.leetcode.learning.q44;

public class Solution {

    public boolean isMatch(String s, String p) {

        //format from left side
        while (p.length() > 0) {
            if (s.length() == 0) {
                break;
            }

            if(p.charAt(0) == '?') {
                p = p.substring(1);
                s = s.substring(1);
                continue;
            } else if(p.charAt(0) == '*') {
                break;
            } else {
                if(p.charAt(0) != s.charAt(0)) {
                    return false;
                } else {
                    p = p.substring(1);
                    s = s.substring(1);
                    continue;
                }
            }
        }

        //format from right side
        while (p.length() > 0) {
            if (s.length() == 0) {
                break;
            }

            int lastIndex = p.length() - 1;
            char lastPChar = p.charAt(lastIndex);
            if(lastPChar == '?') {
                p = p.substring(0, p.length() - 1);
                s = s.substring(0, s.length() - 1);
                continue;
            } else if(lastPChar == '*') {
                break;
            } else {
                if(lastPChar != s.charAt(s.length() - 1)) {
                    return false;
                } else {
                    p = p.substring(0, p.length() - 1);
                    s = s.substring(0, s.length() - 1);
                    continue;
                }
            }
        }

        System.out.println("s:"+s + "  p:"+p);

        //merge *
        if(p.length() - p.replaceAll("\\*","").length() >= 2){
            int p1 = p.indexOf("*"),p2 = p.indexOf("*", p1 + 1);
            while (p2 >= 0) {
                if(p2 - p1 == 1) {
                    p = p.substring(0, p1) + p.substring(p2);
                } else {
                    p1 = p2;
                }
                p2 = p.indexOf("*", p1 + 1);
            }
        }

        //check length
        if(s.length() < p.replaceAll("\\*","").length()) {
            return false;
        }

        if(p.equals("*")) {
            return true;
        }

        int l1 = p.indexOf("*");
        int l2 = p.indexOf("*", l1 + 1);
        while (l2 >= 0) {
            String midStr = p.substring(l1 + 1, l2);
            int test = testValid(s, midStr);
            if (test < 0) {
                return false;
            } else {
                p = p.substring(l2);
                s = s.substring(test + midStr.length());
            }
            l1 = p.indexOf("*");
            l2 = p.indexOf("*", l1 + 1);
        }

        if(p.equals("*") || p.equals(s)) {
            return true;
        }

        return false;
    }

    private int testValid(String origin, String target){
        if(target.contains("?")){
            for (int i = 0; i < origin.length() - target.length() + 1; i++) {
                if(checkEqual(origin.substring(i,i+target.length()), target)){
                    return i;
                }
            }
        } else {
            return origin.indexOf(target);
        }
        return -1;
    }

    private boolean checkEqual(String t, String s){
        if(s.length() != t.length()) {
            return false;
        } else {
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) != '?') {
                    if(s.charAt(i) != t.charAt(i)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution =  new Solution();
        System.out.println(solution.isMatch("aa", "aa"));
//        System.out.println(solution.isMatch("aa", "*"));
//        System.out.println(solution.isMatch("cb", "?a"));
//        System.out.println(solution.isMatch("adceb", "*a*b"));
//        System.out.println(solution.isMatch("acdcb", "a*c?b"));
    }
}

package com.leetcode.learning.q20;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        if (s.length() % 2 != 0){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) {
                    return false;
                }
                char tmp = (char)stack.pop();
                if(s.charAt(i) == ')') {
                    if(tmp != '(') {
                        return false;
                    }
                } else if (s.charAt(i) == '}') {
                    if(tmp != '{') {
                        return false;
                    }
                } else if (s.charAt(i) == ']') {
                    if(tmp != '[') {
                        return false;
                    }
                }
            }
        }

        if (!stack.isEmpty()){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("{[]}"));
        System.out.println(solution.isValid("]"));
    }
}

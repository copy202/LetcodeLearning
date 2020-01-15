package com.leetcode.learning.q32;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        if(null == s || 0 == s.length()) {
            return 0;
        }

        int[] arr = new int[s.length()];

        Stack<KObj> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ele = s.charAt(i);
            if( ele == '(') {
                stack.push(new KObj(i+1, ele));
            } else {
                if (!stack.empty()) {
                    KObj top = stack.pop();
                    arr[i] = top.position;
                    arr[top.position-1] = 1;
                } else {
                    arr[i] = -1;
                }
            }
        }

        int res = 0, tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= 0) {
                res = Math.max(res, tmp);
                tmp = 0;
            } else {
                tmp++;
            }
        }
        res = Math.max(res, tmp);

        return res;

    }

    class KObj{
        int position;
        Character ch;
        KObj(int position, Character ch){
            this.position = position;
            this.ch = ch;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("") == 0 ? true:false);
        System.out.println(solution.longestValidParentheses("(()())") == 6 ? true:false);
        System.out.println(solution.longestValidParentheses("))(") == 0 ? true:false);
        System.out.println(solution.longestValidParentheses("))(()(((((())((()") == 4 ? true:false);
        System.out.println(solution.longestValidParentheses("(((((((((((") == 0 ? true:false);
        System.out.println(solution.longestValidParentheses("((())))))))))()") == 6 ? true:false);
        System.out.println(solution.longestValidParentheses("()()()()()()") == 12 ? true:false);
        System.out.println(solution.longestValidParentheses("))))()((())))))((()))") == 8 ? true:false);
    }
}

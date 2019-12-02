package com.leetcode.learning.q9;

public class Solution {
    public boolean isPalindrome(int x) {
        if(x==0){
            return true;
        }else if(x <0){
            return false;
        }else{
            String orgin = String.valueOf(x);
            int left = orgin.length()/2-1;
            int right;
            if(orgin.length()%2==0){
                right = orgin.length()/2;
            }else{
                right = orgin.length()/2 + 1;
            }
            for (; left >= 0 && right <= orgin.length()-1;) {
                if(orgin.charAt(left) != orgin.charAt(right)){
                    return false;
                }
                left--;
                right++;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isPalindrome(100);
    }
}

package com.leetcode.learning.q5;

public class Solution {
    public String longestPalindrome(String s) {

        if(s.length() == 0){
            return "";
        }

        if(s.length() == 1){
            return s;
        }

        String result = s.substring(0,1);
        StringBuilder sb= new StringBuilder();
        sb.append(s.charAt(0));
        for(int i=1;i<s.length();i++){
            sb.append("#").append(s.charAt(i));
        }
        String orgin = sb.toString();

        String tmp1 = subString(orgin, 1,3);
        String tmp2 = subString(orgin, 2,5);


        result = tmp1.length() > result.length()? tmp1:result;
        result = tmp2.length() > result.length()? tmp2:result;

        return result;
    }

    private boolean check(String orgin, int center, int radio){
        int i=1;
        do {
            if(orgin.charAt(center-i) != orgin.charAt(center+i)){
                return false;
            }
            i++;
            radio--;
        } while (radio>0);
        return true;
    }

    private String subString(String orgin, int startIndex, int winSize){
        String result="";
        for (int i = startIndex; i < orgin.length() - 1; i+=2) {
            if(i - winSize/2 < 0){
                continue;
            }
            if(i+winSize/2 > orgin.length() - 1){
                break;
            }

            //check
            if(check(orgin, i, winSize/2)){
                result = orgin.substring(i-winSize/2,i+winSize/2+1);
                //System.out.println("---:"+tmp2);
                winSize+=4;
                i=startIndex;
            }
        }
        result = result.replaceAll("#","");
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome(""));
    }
}

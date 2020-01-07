package com.leetcode.learning.q13;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<NumUnit> numList = new ArrayList<>();

    {
        numList.add(new NumUnit(1000, "M"));
        numList.add(new NumUnit(900, "CM"));
        numList.add(new NumUnit(500, "D"));
        numList.add(new NumUnit(400, "CD"));
        numList.add(new NumUnit(100, "C"));
        numList.add(new NumUnit(90, "XC"));
        numList.add(new NumUnit(50, "L"));
        numList.add(new NumUnit(40, "XL"));
        numList.add(new NumUnit(10, "X"));
        numList.add(new NumUnit(9, "IX"));
        numList.add(new NumUnit(5, "V"));
        numList.add(new NumUnit(4, "IV"));
        numList.add(new NumUnit(1, "I"));
    }

    public int romanToInt(String s) {
        int result = 0;
        do {
            for (int i = 0; i < numList.size(); i++) {
                int len = s.length() == 1? 1 : numList.get(i).c.length();
                if(s.substring(0, len).equals(numList.get(i).c)){
                    result += numList.get(i).num;
                    s = s.substring(len);
                    break;
                }
            }
        } while (s.length() > 0);

        return result;
    }

    public String intToRoman(int num) {

        int startIndex = 0, currentIndex = startIndex, endIndex = numList.size() - 1;
        StringBuilder sb = new StringBuilder();


        int tmp = 0;
        do {
            tmp = num / numList.get(currentIndex).num;
            int sub = tmp * numList.get(currentIndex).num;
            for (int j = 0; j < tmp; j++) {
                sb.append(numList.get(currentIndex).c);
            }
            num = num - sub;
            currentIndex++;
        } while (num > 0);

        return  sb.toString();
    }

    private class NumUnit {
        int num;
        String c;

        public NumUnit(int num, String c){
            this.num = num;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(901));
        System.out.println(solution.intToRoman(8));
        System.out.println(solution.intToRoman(3));
        System.out.println(solution.intToRoman(4));
        System.out.println(solution.intToRoman(9));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(1994));

        System.out.println(solution.romanToInt("CMI"));
        System.out.println(solution.romanToInt("VIII"));
        System.out.println(solution.romanToInt("III"));
        System.out.println(solution.romanToInt("IV"));
        System.out.println(solution.romanToInt("IX"));
        System.out.println(solution.romanToInt("LVIII"));
        System.out.println(solution.romanToInt("MCMXCIV"));

    }
}

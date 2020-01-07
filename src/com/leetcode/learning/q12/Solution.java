package com.leetcode.learning.q12;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<NumUnit> numList = new ArrayList<>();

    public String intToRoman(int num) {

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
    }
}

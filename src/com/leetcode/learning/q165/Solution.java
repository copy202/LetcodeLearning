package com.leetcode.learning.q165;

public class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1.trim() == ""){
            version1 = "0";
        }

        if(version2.trim() == ""){
            version2 = "0";
        }

        String[] arrayLeft = version1.split("\\.");
        String[] arrayRight = version2.split("\\.");

        int count = Math.max(arrayLeft.length, arrayRight.length);
        for (int i = 0; i < count; i++) {
            String left, right;
            if (i < arrayLeft.length) {
                left = arrayLeft[i];
            } else {
                left = "0";
            }

            if (i < arrayRight.length) {
                right = arrayRight[i];
            } else {
                right = "0";
            }

            if(Integer.valueOf(left).intValue() >  Integer.valueOf(right).intValue()){
                return 1;
            }else if(Integer.valueOf(left).intValue() <  Integer.valueOf(right).intValue()){
                return -1;
            }
        }
        return 0;
    }
}

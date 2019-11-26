package com.leetcode.learning.q42;

public class Solution {
    public int trap(int[] height) {
        return trap2(height, 0);
    }

    public int trap2(int[] height, int startIndex) {
        if (null == height || height.length <= 1) {
            return 0;
        }

        boolean flag = false; // if is start match, set it to true
        int endIndex = 0;
        if (startIndex + 1 < height.length) {
            int right = getValue(height, startIndex + 1, height[startIndex]);
            if (right == 1) {
                return trap2(height, startIndex + 1);
            } else {
                flag = true;
                for (int j = startIndex + 2; j < height.length; j++) {
                    int endValue = getValue(height, j, height[startIndex]);
                    if (endValue == 1) {
                        endIndex = j;
                        flag = false;
                        break;
                    }
                }
                if (flag == true) {
                    if (height[startIndex] > 0) {
                        height[startIndex]--;
                        return trap2(height, startIndex);
                    } else {
                        return trap2(height, startIndex + 1);
                    }
                } else {
                    return calculate(height, startIndex, endIndex) + trap2(height, endIndex);
                }

            }
        }

        return 0;
    }

    private int getValue(int[] array, int x, int y) {
        int y1 = array[x];
        if (y1 == 0) {
            return 0;
        } else {
            if (y - 1 >= y1) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    private int calculate(int[] array, int x, int y) {
        int yLeft = array[x];
        int yRight = array[y];
        int h = Math.min(yLeft, yRight);
        int sum = 0;
        for (int i = x + 1; i < y; i++) {
            int val = h - array[i];
            sum = sum + (val < 0 ? 0 : val);
        }
        return sum;
    }
}

package com.leetcode.learning.q164;

public class Solution {
    public int maximumGap(int[] nums) {
        if(null == nums || nums.length <= 1){
            return 0;
        }

        int result = 0;
        int max = nums[0], min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        int bitCount = max - min + 1;
        //使用byte数据存储，一个bype 8位
        int bytelength = bitCount / 8 + 1;

        byte[] bitContainer = new byte[bytelength];

        for (int i = 0; i < nums.length; i++) {
            int row = (nums[i] - min) / 8;
            byte t = (byte) (0x01 << ((nums[i] - min) % 8));
            bitContainer[row] |= t;
        }

        int step = 0;
        for (int i = 0; i < bitContainer.length; i++) {
            for (int j=0;j<8;j++){
                //比较最后一位是否大于0
                if((bitContainer[i] & 0x01) > 0){
                    result = Math.max(step, result);
                    step = 0;
                }
                step ++;
                bitContainer[i] = (byte) (bitContainer[i] >> 1);
            }
        }
        return result;
    }
}

package com.leetcode.learning.q1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        /* key=the nums value, value= the nums position list*/
        Map<Integer, List<Integer>> dict = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            dict.putIfAbsent(nums[i],new ArrayList<>());
            dict.get(nums[i]).add(i);
        }

        for (Integer key:dict.keySet()){
            if(dict.containsKey(target-key)){
                if(target == 2*key){
                    if(dict.get(key).size() >= 2){
                        return new int[]{dict.get(key).get(0),dict.get(key).get(1)};
                    }
                }else {
                    return new int[]{dict.get(key).get(0), dict.get(target - key).get(0)};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sumIndex = solution.twoSum(new int[]{3,7,2,3}, 6);
    }
}

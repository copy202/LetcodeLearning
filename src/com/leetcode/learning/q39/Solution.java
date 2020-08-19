package com.leetcode.learning.q39;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ex = new ArrayList<>();
        combinationSum(ex, new ArrayList<>(), 0, candidates, target);

        return ex;
    }

    private void combinationSum(List<List<Integer>> ex, List<Integer> res, int level, int[] candidates, int target) {
        for (int i = 0; i * candidates[level] <= target; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(res);
            for (int j = 0; j < i; j++) {
                tmp.add(candidates[level]);
            }
            if (target - candidates[level] * i == 0) {
                ex.add(tmp);
            } else {
                if (level < candidates.length - 1) {
                    combinationSum(ex, tmp, level + 1, candidates, target - candidates[level] * i);
                }
            }
        }
    }


    /**
     * 采用分而治之的思想，元素n选中的情况是 无选中或者1～x，条件是不超过target
     * 递归调用，将大问题转换为子问题解决
     * TODO 优化：缓存level,target的值，可以避免重复计算
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combinationSum(new int[]{7, 1, 5, 2}, 5);
        solution.combinationSum(new int[]{2,3,6,7}, 7);
        solution.combinationSum(new int[]{2,3,5}, 8);
    }
}

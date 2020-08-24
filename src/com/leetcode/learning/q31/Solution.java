package com.leetcode.learning.q31;

public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int flag = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                flag = i;
                break;
            }
        }
        if (flag == nums.length - 1) {
            //交换最后位置
            int tmp = nums[nums.length - 1];
            nums[nums.length - 1] = nums[nums.length - 2];
            nums[nums.length - 2] = tmp;
        } else if (flag == -1) {
            //不存在更大排序，返回最小排序
            swap(nums, 0, nums.length - 1);
        } else {
            //取出最后一个大于flag-1元素作为第一个子序列第一个元素
            int headIndex = -1;
            for (int j = nums.length - 1; j >= flag; j--) {
                if (nums[j] > nums[flag - 1]) {
                    headIndex = j;
                    break;
                }
            }

            int tmp = nums[flag - 1];
            nums[flag - 1] = nums[headIndex];
            nums[headIndex] = tmp;

            swap(nums, flag, nums.length - 1);
        }
    }

    private void swap(int[] nums, int start, int end) {
        for (int i = 0; i < (end - start + 1) / 2; i++) {
            int tmp = nums[i + start];
            nums[i + start] = nums[end - i];
            nums[end - i] = tmp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] obj = new int[]{6, 7, 5};
        //int[] obj = new int[]{7, 5, 6};
//        int[] obj = new int[]{6, 5, 4, 3, 2};
//        int[] obj = new int[]{6, 5, 4, 3, 2, 1};
//        int[] obj = new int[]{6, 5, 3, 4, 2, 1};
        int[] obj = new int[]{1, 4, 3, 2};
        solution.nextPermutation(obj);
        System.out.println("helloworld");
    }
}

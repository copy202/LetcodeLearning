package com.leetcode.learning.q88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if ( 0 == n) {
            return;
        }

        if( 0 == m) {
            System.arraycopy(nums2,0, nums1, 0, n);
            return;
        }

        int x = 0, y = 0, left = m;

        while (x < m && y < n){
            if (nums1[x] > nums2[y]) {
                for (int i = x + left - 1; i >= x; i--) {
                    nums1[i+1] = nums1[i];
                }
                nums1[x] = nums2[y];
                y++;
                m++;
            } else {
                left--;
            }
            x++;
        };

        while (y < n) nums1[x++] = nums2[y++];

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.merge(new int[]{1, 0}, 1, new int[]{2}, 1);
        solution.merge(new int[]{7, 10, 12, 0, 0 , 0}, 3, new int[]{1, 2, 3}, 3);
        solution.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
}

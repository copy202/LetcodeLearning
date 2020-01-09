package com.leetcode.learning.q88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if ( 0 == n) {
            return;
        }

        int x =0, y=0;
        do {
            if (nums1[x] > nums2[y]) {
                int swap = nums1[x];
                nums1[x] = nums2[y];
                nums2[y] = swap;
                x++;
            } else {
                y++;
            }
        }while (x < m && y < n);

    }
}

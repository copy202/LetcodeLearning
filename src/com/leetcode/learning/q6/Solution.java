package com.leetcode.learning.q6;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String convert(String s, int numRows) {
        List[] ll = new List[numRows];
        for (int i = 0; i < numRows; i++) {
            ll[i] = new LinkedList<>();
        }

        int f = numRows>1?(numRows - 1) * 2:1;

        for (int m = 0; m < s.length(); m++) {
            if (m % f < numRows) {
                ll[m % f].add(s.charAt(m));
            } else {
                int xx= 2*numRows - 2 - m % f;
                ll[xx].add(s.charAt(m));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            ll[i].forEach(e->sb.append(e));
        }

        return sb.toString();
    }
}

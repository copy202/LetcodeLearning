package com.leetcode.learning.q17;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    private Map<String, List<String>> mapping = new HashMap<>();

    public Solution(){
        mapping.put("2", List.of("a","b","c"));
        mapping.put("3", List.of("d","e","f"));
        mapping.put("4", List.of("g","h","i"));
        mapping.put("5", List.of("j","k","l"));
        mapping.put("6", List.of("m","n","o"));
        mapping.put("7", List.of("p","q","r","s"));
        mapping.put("8", List.of("t","u","v"));
        mapping.put("9", List.of("w","x","y","z"));
    }

    public List<String> letterCombinations(String digits) {

        TreeNode<String> root = new TreeNode<String>("");
        TreeNode<String> cur = root;
        for (int i = 0; i < digits.length(); i++) {
            String e = digits.substring(i, i+1);
            List<String> entries = mapping.get(e);
            while(cur!=null){
                List<TreeNode<String>> childs = new ArrayList<>();
                for (String child : entries) {
                    childs.add(new TreeNode<String>(child));
                }
                cur=cur.next;
            }

        }
        List<String> resList = new ArrayList<>();
        return resList;
    }
    

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.letterCombinations("23");
    }
}

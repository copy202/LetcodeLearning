package com.leetcode.learning.q30;

import java.util.*;

public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        if(null  == s || s.length() == 0 || null == words || words.length == 0) {
            return res;
        }

        int subLength = words.length * words[0].length();

        for (int i = 0; i < s.length() - subLength + 1;i++) {
            String sub = s.substring(i, i + subLength);
            if(compare(sub, words)) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean compare(String s, String[] words) {
        int wordLength = words[0].length();
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordMap.putIfAbsent(words[i], 0);
            wordMap.compute(words[i], (k,v) -> v+1);
        }

        for (int i = 0; i < s.length(); i+=wordLength) {
            String cword = s.substring(i, i + wordLength);
            if(wordMap.containsKey(cword)) {
                wordMap.compute(cword, (k,v) -> v-1);
                if(wordMap.get(cword)==0){
                    wordMap.remove(cword);
                }
            } else {
                return false;
            }
        }

        if(wordMap.isEmpty()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.compare(solution.findSubstring("", new String[]{"foo", "bar"}).stream().mapToInt(Integer::valueOf).toArray(), new int[]{}));
        System.out.println(Arrays.compare(solution.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}).stream().mapToInt(Integer::valueOf).toArray(), new int[]{0, 9}));
        System.out.println(Arrays.compare(solution.findSubstring("dsfbarfoothefoobarmandsfsdf", new String[]{"foo", "bar"}).stream().mapToInt(Integer::valueOf).toArray(), new int[]{3, 12}));
        System.out.println(Arrays.compare(solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}).stream().mapToInt(Integer::valueOf).toArray(), new int[]{}));
        System.out.println(Arrays.compare(solution.findSubstring("wordgoodgoodgoodbestwordwordwordword", new String[]{"word","good","best","word"}).stream().mapToInt(Integer::valueOf).toArray(), new int[]{12}));
        System.out.println(Arrays.compare(solution.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}).stream().mapToInt(Integer::valueOf).toArray(), new int[]{6,9,12}));

    }
}

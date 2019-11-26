package com.leetcode.learning.q68;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        if (words.length == 1) {
            res.add(
                    words[0] + String.join("", Collections.nCopies(maxWidth - words[0].length(), " ")));
            return res;
        }

        int curSum = 0;
        List<String> tempLine = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {

            //This is proved to the last line
            if(i == words.length - 1){
                if(curSum + tempLine.size() + words[i].length() <= maxWidth) {
                    tempLine.add(words[i]);
                    String left  = String.join(" ", tempLine.toArray(new String[]{}));
                    res.add(left + String.join("", Collections.nCopies(maxWidth-left.length(), " ")));
                }else {
                    res.add(handleLine(tempLine.toArray(new String[]{}), maxWidth, curSum));
                    res.add(words[i] + String.join("", Collections.nCopies(maxWidth - words[i].length(), " ")));
                }
                curSum = 0;
                tempLine.clear();
            } else {
                // word length  + min space split char length  +  new word length
                if(curSum + tempLine.size() + words[i].length() > maxWidth){
                    //over, need a new line
                    res.add(handleLine(tempLine.toArray(new String[]{}),maxWidth, curSum));
                    tempLine.clear();
                    curSum = 0;

                }
                //append to the end
                curSum += words[i].length();
                tempLine.add(words[i]);
            }
        }


        return res;
    }

    private String handleLine(String[] strs, int maxWidth, int cursum){
        if(strs.length == 1){
            return strs[0] + String.join("", Collections.nCopies(maxWidth - cursum, " "));
        }

        StringBuilder sb =  new StringBuilder();

        int yushu = (maxWidth - cursum) % (strs.length - 1);
        int every = (maxWidth - cursum) / (strs.length - 1);
        for (int i = 0; i < strs.length - 1; i++) {
            sb.append(strs[i]);
            if(yushu > 0 ){
                sb.append(String.join("", Collections.nCopies(every + 1, " ")));
                yushu -- ;
            } else {
                sb.append(String.join("", Collections.nCopies(every, " ")));
            }

        }
        sb.append(strs[strs.length-1]);
        return sb.toString();
    }
}

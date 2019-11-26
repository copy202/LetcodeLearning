package com.leetcode.learning.q8;

public class Solution {
    public int myAtoi(String str) {
        if(str == null){
            return 0;
        }
        String lstr = str.trim();
        boolean firstSure = false;//表示初始值是否已经决定
        FirstType first = FirstType.None;
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < lstr.length(); i++) {
            char ch = lstr.charAt(i);
            if(!firstSure){
                //确定首字母
                if(isFlag(ch)){
                    firstSure = true;
                    first = ch == '+'?FirstType.Zheng:FirstType.Fu;
                    sb.append(ch);
                }else if(isNum(ch)){
                    firstSure = true;
                    first = FirstType.Num;
                    sb.append(ch);
                }else {
                    break;
                }
            }else{
                if(!isNum(ch)){
                    break;
                }else{
                    sb.append(ch);
                }
            }

        }
        if(!firstSure){
            //表示整个字符串为空字符串或者无法处理
            return 0;
        }

        if((first == FirstType.Zheng || first == FirstType.Fu) && sb.length() == 1){
            return 0;
        }

        if(isOver(sb.toString(), first)){
            if(first.value == FirstType.Zheng.value || first.value == FirstType.Num.value){
                return Integer.MAX_VALUE;
            }else if(first.value == FirstType.Fu.value){
                return Integer.MIN_VALUE;
            }
        }

        return Integer.valueOf(sb.toString()).intValue();


    }

    private boolean isBlank(char s){
        if(s == ' '){
            return true;
        }
        return false;
    }

    private boolean isNum(char s){
        char left = '0';
        char right = '9';
        if(s >= left && s<= right){
            return true;
        }
        return false;
    }

    private boolean isFlag(char s){
        char m = '-';
        char n = '+';
        if(s==m || s== n){
            return true;
        }
        return false;
    }

    private boolean isOver(String str, FirstType firstType){
        String limit = null;
        if(firstType.value == FirstType.Zheng.value) {
            limit = "+" + String.valueOf(Integer.MAX_VALUE);
        }else if(firstType.value == FirstType.Num.value){
            limit = String.valueOf(Integer.MAX_VALUE);
        }else if(firstType.value == FirstType.Fu.value){
            limit = String.valueOf(Integer.MIN_VALUE);
        }
        int bitnum = limit.length();

        String lstr = str;
        int beginIndex = 0;
        boolean isContinue = true;
        int i=1;
        if(firstType.value == FirstType.Num.value){
            i=0;
        }
        for (; i < lstr.length(); i++) {
            if(isContinue){
                if(lstr.charAt(i) == '0'){
                    beginIndex++;
                }else{
                    isContinue = false;
                }
            }
        }

        lstr = lstr.substring(beginIndex);

        if(lstr.length() > bitnum){
            return true;
        }else if(lstr.length() < bitnum){
            return false;
        }else{
            //compare one by one
            for (int j = 0; j < bitnum; j++) {
                if(lstr.charAt(j) < limit.charAt(j)){
                    return false;
                } else if(lstr.charAt(j) > limit.charAt(j)){
                    return true;
                }
            }
            return false;
        }
    }

    enum FirstType {
        None(0, ""),
        Zheng(1, "+"),
        Fu(2, "-"),
        Num(3, "123"),
        Abc(4, "Abc");

        int value;
        String desc;

        FirstType(int value, String desc){
            this.value = value;
            this.desc = desc;
        }
    }
}

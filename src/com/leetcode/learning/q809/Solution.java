package com.leetcode.learning.q809;

public class Solution {
    public int expressiveWords(String S, String[] words) {
        int count=0;
        for (int i = 0; i < words.length; i++) {
            if(isExpressiveWord(S,words[i])){
                count++;
            }
        }
        return count;
    }

    private boolean isExpressiveWord(String exString, String word) {
        if(word.length() > exString.length()){
            return false;
        }

        int j=0;
        int sameNum = 0;
        for (int i = 0; i < word.length(); i++,j++) {
            //Over Condition
            if(j >= exString.length()){
                return false;
            }
            if(word.charAt(i) != exString.charAt(j)){
                return false;
            }


            //last element compare
            if(i == word.length() -1){
                int flagJ = j;
                for (;j < exString.length();j++){
                    if(exString.charAt(j) != word.charAt(i)){
                        return false;
                    }else {
                        sameNum ++;
                    }
                }
                if(--j > flagJ){
                    if (sameNum < 3){
                        return false;
                    } else {
                        return true;
                    }
                }else {
                    return true;
                }
            }
            if(word.charAt(i) != word.charAt(i+1)){
                char flag = word.charAt(i);
                int flagJ = j;
                for(;j<exString.length();j++){
                    if(flag == exString.charAt(j)){
                        sameNum++;
                    }else {
                        j--;
                        break;
                    }
                }
                if(j > flagJ){
                    if(sameNum < 3){
                        return false;
                    }
                }
                sameNum = 0;
            }else {
                sameNum ++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //solution.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo","heeellooooooo"});
        solution.expressiveWords("vvvppppeeezzzzztttttkkkkkkugggggbbffffffywwwwwwbbbccccddddddkkkkksssppppddpzzzzzhhhhbbbbbmmmy", new String[]{"vvpeezttkkuggbbfywwbbccddkkspdpzhbbmmyy","vvppeeztkkugbfywwbccddkksspdppzhhbmyy","vppezzttkkugbffyywbccddksspddpzhhbmy","vvppezztkugbffyywwbbccddkssppddpzzhhbbmmy","vvppezttkuggbfyywwbbcddkspdppzhhbmy","vppeezzttkkuugbfyywwbbccdkkssppdpzzhbbmy","vpeezztkkugbbffyywwbbccddkksppdpzzhhbbmmy","vppeeztkkuuggbffywbbccddkksppdppzhhbmyy","vpeeztkkuggbfyywbbccdksppdpzhbmy","vpeezztkkugbffywwbbccdkkssppddppzzhhbbmmy","vvpeztkkugbbfyywbcdkssppddpzzhhbbmyy","vpezztkugbbffyywwbcddksppddpzzhbbmy","vvpeezztkkugbbffywwbccdkkspddpzzhbmmyy","vvpeezzttkkuuggbbffyywbbccdkspdppzhhbmy","vvppeezztkkuggbbfywbcdkspdpzhhbmyy","vvppeezzttkkuugbffyywwbbccddkkspddpzzhbmyy","vppezztkuuggbffywwbcdksspdppzhhbmyy","vvppeezzttkuuggbffywbccddkksspddppzzhhbmmy","vvppezzttkuggbffywbbccdkspddppzzhhbmy","vvpezzttkuugbbfywwbccdkssppdpzhbbmmy","vvpeezzttkuugbbffyywbccdksppddppzhhbmyy","vpeezzttkkuggbbffywbccddksppddpzhhbbmy","vvpezttkuuggbffywwbbccddkspdppzhhbmmyy","vppeezzttkkuugbffywbccddksppddpzhhbmmyy","vvpezttkkuugbbfywbccdkspddppzzhbbmmy","vppezzttkkuugbbffywwbcddkssppddpzhhbmmy","vppezzttkugbfywbbcdksppddppzzhhbmyy","vppeeztkuggbbffywbbccdkkspddppzzhbbmmy","vvpeeztkuuggbbfywbcdkksspddppzhhbbmmyy","vpezttkkuuggbbffyywwbbcdksspddppzhhbmy","vpeezzttkkuuggbffywwbccdkksspddppzzhbmyy","vpezttkkuugbffyywbccdksspddppzhbbmmyy","vvppezztkugbbffyywbbccdkksppdppzhbmyy","vvpeezttkuggbbfyywwbbcddkksppdpzzhbbmyy","vvpeztkuuggbffyywbbccdkksspddppzzhbbmy","vppeezzttkugbbffyywbccddksppdppzzhbmmyy","vppeezttkkuugbbfywwbccddkksspdpzhhbmmy","vpeezzttkugbbffywbbccdkksspddppzhbbmyy","vpeezttkkuugbbfywbbccddksppddppzzhhbmmy","vpeezztkuuggbbffywwbbccddksspddpzzhhbbmmyy","vppeezttkkuggbbffyywwbccdksspdpzzhbmy","vpezzttkkuugbbfyywbbcdksspdppzzhbbmyy","vvppezttkkuggbbfyywbbccdkksspddpzhbbmyy","vvpezzttkuggbbffyywbbcdkksppdpzzhbmmyy","vvpeztkugbfywwbccddkkspddpzhhbbmyy","vvppezttkuugbbfyywwbcddkksspdppzhhbbmy","vvpeeztkkuuggbbfywwbcdkspddpzzhhbmmy","vvpeezttkugbffywbbccdkkssppddppzhhbbmyy","vpeztkuuggbbfyywwbcddksppddpzhbbmy","vppeztkuggbbfyywbcdksspdppzzhhbmy","vppeezttkkugbbffyywbccddkksppdpzhhbmy","vvppeeztkugbfyywbcdkksppdppzhbmyy","vpezttkuugbbffywbcdksppddpzzhhbbmmy","vppezzttkuugbfyywbcddkksspdpzhbbmmy","vppezzttkkuggbffywbbcdksspdpzzhhbbmmyy","vpezzttkuggbfyywbbccdksspdpzhhbbmmy","vvppezttkkugbffyywbcdkssppdpzzhbmy","vvpeezttkkuuggbbfyywbbccdkspdppzhhbmy","vpeezttkkuugbfywbccddkksppddpzzhhbmmy","vvppezttkuuggbbffywbbccdkksppdpzzhhbbmmy","vvppeeztkuggbbffyywbccdksspddppzzhbmmyy","vvppeezztkuggbfywwbccddkkspddpzhbbmy","vpezttkuuggbfyywwbcdkkspdpzhhbbmmyy","vppezzttkuggbffywbbcdkkssppddppzhhbmyy","vppeztkuuggbffyywbccdkkspdppzzhhbmmyy","vppeezztkuuggbfywbccddkksspddppzhhbbmyy","vvppeztkuugbfywwbccdkkspddppzzhhbmmy","vvpezztkuugbbffyywwbbccddksppdpzhbbmmyy","vvpezzttkkuuggbffyywwbbcdkspdpzhbmmyy","vvppeztkkuuggbbfyywbbccdksppdppzzhbmmyy","vvppezztkuggbffyywwbcddkkssppdpzhbmmyy","vvpezzttkkuggbbffywwbcddkksspdpzzhhbbmmy","vpezztkkuuggbfyywwbccddkssppdppzhhbbmmy","vvppezztkuugbffywwbccdkkspdppzhhbmmy","vpeztkugbfyywwbcdkksspdppzzhbmmy","vvpeezzttkkugbbfywwbcdkkspdpzzhhbmmy","vpezzttkuuggbbfywbccdkspddppzzhhbbmmy","vppeztkkuugbffyywwbbcddksspddppzhbbmyy","vpeztkkuggbffyywbbccddkssppdppzhbmyy","vvppeezztkuggbffyywwbcddkksppdppzhbmyy","vpeezztkugbfyywbbccdkkspdppzhbmmyy","vvppeezttkugbfywwbcddkkssppdppzhbmmyy","vpeeztkuggbffywwbbccddksspdppzzhhbmmy","vvppeeztkuugbfywbcddkssppddppzzhhbbmyy","vpezzttkuggbbffyywwbbccdkssppddppzhbbmy","vpezttkugbfywbbcddkksspddppzhbbmy","vpeezzttkkuggbbffyywwbccddkspddppzhbmyy","vppeezzttkugbffywbccdkkspddpzhhbbmyy","vpezzttkuggbbfyywbbccdkksspddpzzhhbmmy","vvppezttkugbfywwbbcdkksspddpzzhhbbmyy","vppezztkkuggbffyywbcddkkssppddpzzhhbbmmy","vppeztkkuggbfywwbccdkksppdppzhhbmmy","vvpeezzttkugbffyywwbbcddkssppddpzzhbmmy","vvpezztkkuuggbfyywbccdkksspddpzhhbbmyy","vpezttkuuggbffywbbccdksppdpzhbmmyy","vvpezzttkuggbbfywbccddksspdpzzhhbmmy","vvpeezzttkkugbbfywwbcdkksppddpzhbmy","vppeezttkkuugbbfyywwbcddkkspdpzhhbbmmyy","vvppeeztkkuugbbfyywwbbcddkksspdppzhbbmyy","vvpeezzttkkuugbfywwbbcddkspdpzzhbbmyy"});
    }
}

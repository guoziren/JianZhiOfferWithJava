package com.ustc.leetcode.datastrcture.string;

/**
 *  最长公共前缀(简单)
 */
public class L14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        int min = Integer.MAX_VALUE;
        for (String str : strs) {
            min = Math.min(str.length(),min);
        }
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < min; i++) {
            char temp = strs[0].charAt(i);
            for (String str : strs) {
                 if(temp != str.charAt(i)){
                     flag = false;
                     break;
                 }
            }
            if (!flag){
                break;
            }
            sb.append(temp);
        }
        return sb.toString();
    }
}

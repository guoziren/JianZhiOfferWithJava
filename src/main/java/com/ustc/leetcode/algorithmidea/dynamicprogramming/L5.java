package com.ustc.leetcode.algorithmidea.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

/**
 *  5. 最长回文子串(美团Android实习一面  2020年)
 *  https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class L5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        int n = s.length();
        char[] array = s.toCharArray();
        boolean[][] table = new boolean[n][n];
        String result = s.substring(0,1);
        for (int l = 0; l < n; l++) {
            for (int i = 0; i < n; i++) {
                int j = i + l;
                //如果越界
                if (j >= n){
                    break;
                }
                //长度为1
                if (l == 0){
                    table[i][j] = true;
                    //长度为2
                }else if(l == 1){
                    table[i][j] = array[i] == array[j];
                    //长度>2
                }else{
                    table[i][j] = table[i + 1][j - 1] && array[i] == array[j];
                }
                if (table[i][j] && j - i + 1 > result.length()){
                    result = s.substring(i,j+1);
                }
            }
        }
        return result;

    }

}

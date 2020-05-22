package com.ustc.leetcode.datastrcture.string;

/**
 *  409. 最长回文串
 *  https://leetcode-cn.com/problems/longest-palindrome/description/
 */
public class L409 {
    public int longestPalindrome(String s) {
        int[] arr = new int[52];

        //这里如果是fori循环，效率会降低一些
        for (char c : s.toCharArray()) {
            arr[getIndex(c)]++;
        }
        boolean hasOdd = false;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0){
                count = count + arr[i];
            }else {
                hasOdd = true;
                count = arr[i] - 1 > 0 ? count + arr[i]- 1 : count;
            }
        }
        if (hasOdd){
            count++;
        }
        return count;
    }

    private int getIndex(char c) {
        if (c >= 'a' && c <= 'z'){
            return c - 'a';
        }else if(c >= 'A' && c <= 'Z'){
            return c - 'A' + 26;
        }else{
            throw new RuntimeException("输入有误");
        }

    }
}

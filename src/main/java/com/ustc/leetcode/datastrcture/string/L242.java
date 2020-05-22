package com.ustc.leetcode.datastrcture.string;

import org.junit.Test;

/**
 *  242. 有效的字母异位词
 *  https://leetcode-cn.com/problems/valid-anagram/
 *  什么是字母异位词anagram?
 *  字母相同，排列顺序不同
 *
 */
public class L242 {
    //假设n是s的长度，时间复杂度O(n),空间复杂度O(1)
    public boolean isAnagram(String s, String t) {
        //两个字符串相同或者长度不同返回false
        if (s == t || s.length() != t.length()){
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr2[t.charAt(i) - 'a']++;
        }
        //比较2个字符串分别含有26个字母的数量，有1个不同则返回false
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
       String s1 = "";
       String s2 = "";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }

}

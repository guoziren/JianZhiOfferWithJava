package com.ustc.leetcode.datastrcture.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * 205. 同构字符串
 * https://leetcode-cn.com/problems/isomorphic-strings/description/
 * 什么叫同构？
 * foo->bar o映射到了2个不同的，不同构。
 */
public class L205 {

    public boolean isIsomorphic(String s, String t) {
        if (s == t){
            return true;
        }
        HashMap<Character,Character> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (!map.containsKey(c1)){
                if (map.containsValue(c2)){
                    return false;
                }
                map.put(c1,c2);
            }else{
                if (map.get(c1) != c2){
                    return false;
                }
            }
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(isIsomorphic("egg","add"));
        System.out.println(isIsomorphic("foo","bar"));
        System.out.println(isIsomorphic("paper","title"));
    }

}

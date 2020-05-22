package com.ustc.leetcode.datastrcture.stack_queue;

import java.util.HashMap;
import java.util.LinkedList;


/**
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 * 时间上击败92.18%
 */
public class L20 {
    private HashMap<Character,Character> map;
    private LinkedList<Character> stack;
    public boolean isValid(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        char[] chars = s.toCharArray();
        map = new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');
        stack = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if(isRightSymbol(chars[i])){
                 if(!compare(chars[i],stack)){
                     return false;
                 };
            }else{
                stack.push(chars[i]);
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }

    private boolean compare(char aChar, LinkedList<Character> stack) {
        if (stack.isEmpty()){
            return false;
        }
        return stack.pop().equals(map.get(aChar));
    }

    private boolean isRightSymbol(char aChar) {
        if (aChar == '[' ||aChar == '{' ||aChar == '(' ){
            return false;
        }
        return true;
    }
}

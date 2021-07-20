package com.ustc.leetcode.basic.other;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 22. 括号生成
 */
public class L22 {
    /**
     * 暴力法， 输入为n, 则最终有2n个字符， 2n个位置，每个位置2种选择， 序列总共有2的2n次方个，逐个校验是否合法
     * 此法效率较低
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] array = new char[2 * n];
        generate(array, 0 ,result);
        return result;
    }

    /**
     * 递归遍历
     * @param array
     * @param position
     * @param result
     */
    private void generate(char[] array, int position, List<String> result) {
        if (position == array.length) {
            String s = new String(array);
            if(valid(array)) {
                result.add(s);
            }
            return;
        }
        array[position] = '(';
        generate(array, position + 1, result);
        array[position] = ')';
        generate(array, position + 1, result);
    }

    private boolean valid(char[] s) {
        int balance = 0;
        for (char c : s) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        if (balance == 0) {
            return true;
        }
        return false;
    }
}


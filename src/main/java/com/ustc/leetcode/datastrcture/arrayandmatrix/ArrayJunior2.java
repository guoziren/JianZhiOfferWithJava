package com.ustc.leetcode.datastrcture.arrayandmatrix;

import java.util.LinkedList;
import java.util.function.ToIntFunction;

/**
 * 加一
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
 */
public class ArrayJunior2 {
    public int[] plusOne(int[] digits) {
        LinkedList<Integer> list = new LinkedList<>();
        int jinwei = 0;
        for (int i = digits.length - 1; i >= 0 ; i--) {
            int current = (i == digits.length - 1) ? digits[i] + 1 : digits[i];
            int temp = 0;
            if (current  + jinwei > 9) {
                jinwei = 1;
                temp = 0;
            } else {
                temp = current  + jinwei;
                jinwei = 0;
            }
            list.addFirst(temp);
        }
        if (jinwei == 1) {
            list.addFirst(1);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

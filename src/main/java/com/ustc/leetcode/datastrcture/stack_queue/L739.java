package com.ustc.leetcode.datastrcture.stack_queue;

import org.junit.Test;

import java.util.Stack;

/**
 * 739. 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/description/
 */
public class L739 {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;


    }

}

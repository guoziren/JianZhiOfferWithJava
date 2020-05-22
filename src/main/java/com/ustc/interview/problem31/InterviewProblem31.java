package com.ustc.interview.problem31;

import org.junit.Test;

import java.util.Stack;

/**
 * 面试题31:
 */
public class InterviewProblem31 {
    @Test
    public void test(){
        int[] a = {1,2,3,4,5};
        int[] b = {4,5,3,2,1};
        IsPopOrder(a,b);
    }
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0,j = 0;
        while(j < popA.length){
            //先入栈，当栈是空或者栈顶 不是 弹出序列的当前的数的时候
            while (stack.isEmpty() || stack.peek() != popA[j]){
                if (i == pushA.length){
                    break;
                }
                stack.push(pushA[i]);
                i++;
            }
            //找到之后，弹出一个，全部入栈后，再进入到这里不等时，return false
            if (stack.peek() != popA[j]){
                return false;
            }
            stack.pop();
            j++;
        }
        if (stack.isEmpty() && j == popA.length){
            return true;
        }

        return false;
    }
}

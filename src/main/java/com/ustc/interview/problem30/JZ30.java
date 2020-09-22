package com.ustc.interview.problem30;


import java.util.LinkedList;

/**
 * 面试题30：包含min元素的栈
 */
public class JZ30 {
    private LinkedList<Integer> stack1 = new LinkedList<>();
    private LinkedList<Integer> stack2 = new LinkedList<>();
    public void push(int node) {
        stack1.push(node);
        if (stack2.isEmpty()){
            stack2.push(node);
        }else{
            if (node <= stack2.peek().intValue()){
                stack2.push(node);
            }
        }
    }

    public void pop() {
        int top = stack1.pop();
        if (top == stack2.peek().intValue()){
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}

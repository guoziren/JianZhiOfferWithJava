package com.ustc.leetcode.datastrcture.stack_queue;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * 基本操作 push(x),pop,empty,peek
 * Note:用2个栈去实现，用的Stack类
 */
public class L232 {
    /** Initialize your data structure here. */
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public L232() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.empty()) {
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
        }
        return (stack2.pop());
    }

    /** Get the front element. */
    public int peek() {
        if (stack2.empty()) {
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
        }
        return (stack2.peek());
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack1.size() == 0 && stack2.size() == 0){
            return true;
        }else{
            return false;
        }
    }
}

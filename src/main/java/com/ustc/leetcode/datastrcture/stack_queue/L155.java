package com.ustc.leetcode.datastrcture.stack_queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class L155 {
    /* 法一，时间击败43.5%
     *
     *
        private PriorityQueue<Integer> queue;
        private LinkedList<Integer> stack;


        public L155() {
            queue = new PriorityQueue<>();
            stack = new LinkedList<>();
        }

        public void push(int x) {
            stack.push(x);
            queue.add(x);
        }

        public void pop() {
            int x = stack.pop();
            queue.remove(x);
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return queue.peek();
        }

     */
    //法二：时间不稳定 ，最好击败97.63,最差43.5%
    private LinkedList<Integer> helper;
    private LinkedList<Integer> stack;


    public L155() {
        stack = new LinkedList<>();
        helper = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (helper.isEmpty() || x <= helper.peek()){
            helper.push(x);
        }else{
            helper.push(helper.peek());
        }
    }

    public void pop() {
        stack.pop();
        helper.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return helper.peek();
    }

}




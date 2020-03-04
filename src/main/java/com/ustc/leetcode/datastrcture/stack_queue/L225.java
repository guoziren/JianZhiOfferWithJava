package com.ustc.leetcode.datastrcture.stack_queue;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 225. 用队列实现栈
 * https://leetcode-cn.com/problems/implement-stack-using-queues/description/
 * 思路：用2个队列来模拟，用hashmap标记一个队列为首队列，另一个为尾队列。
 */

public class L225 {
    private LinkedList<Integer> queue1;
    private LinkedList<Integer> queue2;
    private HashMap<String,LinkedList<Integer>> map;
    private static final String FRONT_QUEUE = "FRONT_QUEUE";
    private static final String BACK_QUEUE = "BACK_QUEUE";
    @Test
    public  void test1() {
        L225 l225 = new L225();
        l225.push(1);
        l225.push(2);
        l225.push(3);
        System.out.println(l225.pop());
        System.out.println(l225.pop());
        System.out.println(l225.pop());
    }
 
    @Test
    public  void test2() {
        L225 l225 = new L225();
        l225.push(1);
        System.out.println(l225.pop());
        System.out.println(l225.empty());
    }
    @Test
    public  void test3() {
        L225 l225 = new L225();
        l225.push(1);
        System.out.println(l225.top());
        System.out.println(l225.pop());
        System.out.println(l225.empty());
    }
    @Test
    public  void test4() {
        L225 l225 = new L225();
        l225.push(1);
        l225.push(2);
        l225.push(3);

        System.out.println(l225.top());
        l225.push(4);
        l225.push(5);
        System.out.println(l225.top());
        System.out.println(l225.pop());
        System.out.println(l225.pop());
        System.out.println(l225.pop());
        System.out.println(l225.pop());
        System.out.println(l225.pop());
    }


    /** Initialize your data structure here. */
    public L225() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
        map = new HashMap<String, LinkedList<Integer>>();
        map.put(FRONT_QUEUE,queue1);
        map.put(BACK_QUEUE,queue1);
    }

    /** Push element x onto stack. */
    public void push(int x) {
         map.get(BACK_QUEUE).add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       //调用函数保证不空
        if (queue2.size() == 0){
            while (queue1.size() > 1){
                queue2.addLast(queue1.removeFirst());
            }
            map.put(FRONT_QUEUE,queue2);
            map.put(BACK_QUEUE,queue2);
            return queue1.removeFirst();
        }else if(queue1.size() == 0){
            while (queue2.size() > 1){
                queue1.addLast(queue2.removeFirst());
            }
            map.put(FRONT_QUEUE,queue1);
            map.put(BACK_QUEUE,queue1);
            return queue2.removeFirst();
        }else{
             LinkedList<Integer> back = map.get(BACK_QUEUE);
             LinkedList<Integer> front = map.get(FRONT_QUEUE);
             while (back.size() > 1){
                 front.addLast(back.removeFirst());
             }
            map.put(FRONT_QUEUE,front);
            map.put(BACK_QUEUE,front);
            return back.removeFirst();
        }
    }

    /** Get the top element. */
    public int top() {
        //调用函数保证不空
        if (queue2.size() == 0){
            while (queue1.size() > 1){
                queue2.addLast(queue1.removeFirst());
            }
            map.put(FRONT_QUEUE,queue2);
            map.put(BACK_QUEUE,queue1);
            return queue1.getLast();
        }else if(queue1.size() == 0){
            while (queue2.size() > 1){
                queue1.addLast(queue2.removeFirst());
            }
            map.put(FRONT_QUEUE,queue1);
            map.put(BACK_QUEUE,queue2);
            return queue2.getLast();
        }else{
            LinkedList<Integer> back = map.get(BACK_QUEUE);
            LinkedList<Integer> front = map.get(FRONT_QUEUE);
            while (back.size() > 1){
                front.addLast(back.removeFirst());
            }

            return back.getLast();
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (queue1.size() == 0 && queue2.size() == 0){
            return true;
        }else {
            return false;
        }
    }
}

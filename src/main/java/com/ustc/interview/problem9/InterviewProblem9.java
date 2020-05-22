package com.ustc.interview.problem9;

import java.util.Stack;

public class InterviewProblem9 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
    public boolean isEmpty(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            return true;
        }
        return false;
    }
}

package com.ustc.interview.problem10;

import org.junit.Test;

import java.util.Calendar;

public class InterviewProblem10 {

    public long fib(int n){
        long[] table = new long[n + 1];

        table[0] = 0;
        table[1] = 1;
        for (int i = 2; i <= n ; i++) {
            table[i] = table[i - 1] + table[i - 2];
           // System.out.println(table[i]);
        }
        return table[n];
    }
    public long fib2(long n){
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        return fib2(n-1) + fib2(n - 2);
    }
    public int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        int n1 = 0;
        int n2 = 1;
        int result = 0;
        for(int i = 2;i <= n;i++){
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        return result;
    }

    @Test
    public void test(){
        System.out.println("InterviewProblem10.test");
        long begin = System.currentTimeMillis();
        System.out.println(fib(100));
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
    @Test
    public void test2(){
        System.out.println("InterviewProblem10.test");
        long begin = System.currentTimeMillis();
        System.out.println(fib2(45));
        long end = System.currentTimeMillis();
        System.out.println(end - begin);

    }

    //青蛙跳台阶🐸
    public int JumpFloor(int target) {
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }

        int n1 = 1;
        int n2 = 2;
        int result = 0;
        for(int i = 3;i <= target;i++){
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        return result;
    }
    //变态跳台阶
    public int JumpFloorII(int target) {
        if(target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        int[] arr = new int[target + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= target ; i++) {
            for (int j = i - 1; j > 0 ; j++) {
                arr[i] += arr[j];
            }
            arr[i] += 1;
        }
        return arr[target];
    }
}

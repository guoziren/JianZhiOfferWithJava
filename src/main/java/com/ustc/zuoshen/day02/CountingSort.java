package com.ustc.zuoshen.day02;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 计数排序
 */
public class CountingSort {

    public static void countingSort(int[] a,int[] b,int k){
        int[] c = new int[k+1];
        for (int i = 0; i <= k ; i++) {
            c[i] = 0;
        }
        for (int i = 0; i < a.length; i++) {
            c[a[i]] = c[a[i]] + 1;
        }
        //now c[i]表示原始数组中数i的个数
        for (int i = 1; i <= k ; i++) {
            c[i] = c[i] + c[i - 1];
        }
        //now c[i]表示<=i的个数
        for (int i = a.length - 1; i >= 0 ; i--) {
            int t = a[i];
            b[c[t] - 1] = t; //a[j]的最终位置
            c[t] = c[t] - 1;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{95,94,91,98,99,90,99,93,91,92};
        int[] b = new int[a.length];
        LinkedList list;
        int k = 99;
        countingSort(a,b,k);
        System.out.println(Arrays.toString(b));
    }
}

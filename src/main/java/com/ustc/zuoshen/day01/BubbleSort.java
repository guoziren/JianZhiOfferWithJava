package com.ustc.zuoshen.day01;

import com.ustc.zuoshen.util.Duishuqi;
import org.junit.Test;

/**
 * 冒泡排序：BubbleSort
 */
public class BubbleSort {
    @Test
    public void test(){
        int testTime = 5000;
        int maxSize = 100;
        int maxValue = 100;
        boolean isSuccess = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Duishuqi.generateRandomArray(maxSize,maxValue);
            int[] arrCopy = Duishuqi.copyArray(arr1);
            bubbleSort(arr1);
            Duishuqi.AbsoluteRightSort(arrCopy);
            if (!Duishuqi.isEqual(arr1, arrCopy)) {
                isSuccess = false;
                break;
            }
        }
        System.out.println(isSuccess ? "Nice!" : "Bad!");

        int[] arr = Duishuqi.generateRandomArray(maxSize, maxValue);
        Duishuqi.printArray(arr);
        bubbleSort(arr);
        Duishuqi.printArray(arr);
    }
    public void bubbleSort(int[] arr){
        if (arr == null || arr.length <= 1){
            return;
        }
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            boolean flag = true;
            for (int j = 1; j < len - i; j++) {
                if (arr[j] < arr[j-1]){
                  swap(arr,j,j-1);
                  flag = false;
                }
            }
            if (flag){
                break;
            }
        }
    }
    public void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

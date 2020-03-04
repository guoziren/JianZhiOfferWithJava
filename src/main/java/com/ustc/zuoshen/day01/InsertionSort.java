package com.ustc.zuoshen.day01;

import com.ustc.zuoshen.util.Duishuqi;
import org.junit.Test;

/**
 * 插入排序：InsertionSort
 */
public class InsertionSort {
    @Test
    public void test(){
        int testTime = 5000;
        int maxSize = 100;
        int maxValue = 100;
        boolean isSuccess = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Duishuqi.generateRandomArray(maxSize,maxValue);
            int[] arrCopy = Duishuqi.copyArray(arr1);
            insertionSort(arr1);
            Duishuqi.AbsoluteRightSort(arrCopy);
            if (!Duishuqi.isEqual(arr1, arrCopy)) {
                isSuccess = false;
                break;
            }
        }
        System.out.println(isSuccess ? "Nice!" : "Bad!");

        int[] arr = Duishuqi.generateRandomArray(maxSize, maxValue);
        Duishuqi.printArray(arr);
        insertionSort(arr);
        Duishuqi.printArray(arr);
    }
    public void insertionSort(int[] arr){
        if (arr == null || arr.length <= 1){
            return;
        }
        int len = arr.length;
        int j = 0;
        for (int i = 1; i < len; i++) {
            int temp = arr[i];
            for ( j = i; j > 0 && temp < arr[j-1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

}

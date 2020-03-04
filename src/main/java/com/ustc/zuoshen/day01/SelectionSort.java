package com.ustc.zuoshen.day01;

public class SelectionSort {
    public void insertionSort(int[] arr){
        if (arr == null || arr.length <= 1){
            return;
        }
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int k = i + 1; k < len; k++) {
                minIndex = arr[k] < arr[minIndex] ? k : minIndex;
            }
            swap(arr,minIndex,i);
        }
    }
    public void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

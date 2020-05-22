package com.ustc.zuoshen.day02;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int a[],int left,int right){
        if (left < right){
            int q = partition2(a,left,right);
            quickSort(a,left,q-1);
            quickSort(a,q +1 ,right);
        }
    }

    private static int partition(int[] a, int p, int r) {
        int x = a[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (a[j] <= x){
               i++;
                swap(a, i, j);
            }
        }
        swap(a,i+1,r);
        return i + 1;
    }
    private static int partition2(int[] array, int left, int right) {

        //选主元
        int privot = array[right];
       //划分子集
        int i = left - 1,j = right;
        for (;;){
            //大于等于的放右边
            while (array[++i] < privot){}//红色警报
            while (array[j--] > privot){}//红色警报
            //相等的时候也交换
            if (i < j){
                swap(array,i,j);
            }else{
                break;
            }
        }
        swap(array,i,right);
        return i ;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-2,1,-3,4,-1,2,1,-5,4};
//        int[] a = new int[]{4,1,-3,4,-1,2,1,4,4};
        QuickSort.quickSort(a,0,a.length - 1);
        System.out.println(Arrays.toString(a));
    }



    void quick_sort(int[] arr,int length){
        quickSort(arr,0,length - 1);
    }
}

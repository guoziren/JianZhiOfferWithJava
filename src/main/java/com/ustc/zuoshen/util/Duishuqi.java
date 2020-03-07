package com.ustc.zuoshen.util;

import java.util.Arrays;

public class Duishuqi {
    //实现一个随机样本产生器：随机生成一个[0,maxSize范围]任意]长度，值（范围[-maxValue,maxValue]）任意的数组
    public static int[] generateRandomArray(int maxSize,int maxValue){
        //生成随机数组
        int size = (int)((maxSize + 1) * Math.random());
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)((maxValue + 1) * Math.random());
        }
        return arr;
    }
    //实现一个随机样本产生器：随机生成一个[0,maxSize范围]任意]长度，值（范围[0,maxValue-1]）任意的数组
    public static int[] generateRandomNonNegativeArray(int maxSize,int maxValue){
        //生成随机数组
        int size = (int)((maxSize + 1) * Math.random());
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)((maxValue ) * Math.random());
        }
        return arr;
    }
    //实现一个随机样本产生器：随机生成一个[0,maxSize范围]任意]长度，值（范围[a-z]）任意的小写字母数组
    public static char[] generateRandomLetterArray(int maxSize){
        //生成随机数组
        int size = (int)((maxSize + 1) * Math.random());
        char[] arr = new char[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (char)('a' + (int)(26 * Math.random()));
        }
        return arr;
    }
    public static void AbsoluteRightSort(int[] arr){
        Arrays.sort(arr);
    }
    // 因为是原地排序，会改变原数组，所以复制一份两个算法使用
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // 4.实现连个方法对比的方法
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    // 可有可无
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

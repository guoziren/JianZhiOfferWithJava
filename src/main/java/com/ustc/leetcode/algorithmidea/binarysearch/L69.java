package com.ustc.leetcode.algorithmidea.binarysearch;

import org.junit.Test;

/**
 * 69. x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/description/
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class L69 {
    public int mySqrt(int x) {
        int low = 1;
        int high = x;
//        int mid = (low + high) / 2;
        //要找到第一个平方大于x的前一个整数 或者等于x的
        while (low <= high){
            //这句写得不好也会整型溢出
            int mid = low + (high - low) /2;
            //平方会溢出
            long r = (long)mid * (long)mid;
            if (r == x){
                return mid;
            }else if(r > x){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return high;
    }
    @Test
    public void test(){
//        System.out.println(mySqrt(4));
        System.out.println(mySqrt(2147395599));
    }

}

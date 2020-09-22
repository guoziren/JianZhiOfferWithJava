package com.ustc.leetcode.datastrcture.arrayandmatrix;

import org.junit.Test;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

/**
 * 215. 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class L215 {
    public int findKthLargest(int[] nums, int k) {



       return quickSelect(nums,0,nums.length -1,nums.length - k);
    }
    public int quickSelect(int[] a, int l, int r, int index) {
        int q = partition(a,l,r);
        if (q == index){
            return a[q];
        }else{
            return q < index ? quickSelect(a,q+1,r,index) : quickSelect(a,l,q-1,index);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int privot = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] <= privot){
                swap(nums,++i,j);
            }
        }
        swap(nums,i+1,right);
        return i+1;
    }

    private void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
    @Test
    public void test(){
        int[] arr = {3,2,3,1,2,4,5,5,6};
//        int[] arr = {3,2,1,5,6,4};
        System.out.println(findKthLargest(arr,4));
    }

}

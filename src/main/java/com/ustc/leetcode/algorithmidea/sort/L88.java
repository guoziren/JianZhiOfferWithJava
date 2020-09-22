package com.ustc.leetcode.algorithmidea.sort;

/**
 * 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class L88 {
    /**
     * 从后往前扫描
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || n == 0){
            return ;
        }
        int p = m + n - 1;
        int p1 = m - 1,p2 = n - 1;
        while (p1 >= 0 && p2 >= 0){
            if (nums1[p1] < nums2[p2]){
                nums1[p] = nums2[p2];
                p2--;
            }else{
                nums1[p] = nums1[p1];
                p1--;
            }
            p--;
        }
        while (p1 >= 0){
            nums1[p] = nums1[p1];
            p1--;
            p--;
        }
        while (p1 >= 0){
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
}

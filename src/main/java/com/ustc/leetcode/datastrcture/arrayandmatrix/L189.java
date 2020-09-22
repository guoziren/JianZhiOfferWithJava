package com.ustc.leetcode.datastrcture.arrayandmatrix;

/**
 *  https://leetcode-cn.com/problems/rotate-array/
 *  189 旋转数组
 */
public class L189 {
    public void rotate(int[] nums, int k) {
        int front_rotate_num = k % nums.length;
        if (front_rotate_num > 0){
            rotate(nums,0,nums.length - 1);
            rotate(nums,0,front_rotate_num - 1);
            rotate(nums,front_rotate_num,nums.length - 1);
        }
    }
    private void rotate(int[] nums, int start,int end) {
        while (start < end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }

}

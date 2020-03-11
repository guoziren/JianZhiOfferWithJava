package com.ustc.leetcode.datastrcture.stack_queue;

import com.sun.codemodel.internal.JWhileLoop;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/next-greater-element-ii/description/
 * 503. 下一个更大元素 II
 */
public class L503 {
    /*O(N方)的时间复杂度，太慢，只击败了11.95%
    public int[] nextGreaterElements(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = findNextGrater(nums,i);
        }
        return arr;
    }

    private int findNextGrater(int[] nums, int i) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[i]){
                return nums[j];
            }
        }
        for (int j = 0; j < i; j++) {
            if (nums[j] > nums[i]){
                return nums[j];
            }
        }
        return -1;
    }

     */
    public int[] nextGreaterElements(int[] nums) {
        return null;
    }
}

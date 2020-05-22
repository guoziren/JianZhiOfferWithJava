package com.ustc.leetcode.datastrcture.arrayandmatrix;

/**
 *  645. 错误的集合
 *  https://leetcode-cn.com/problems/set-mismatch/description/
 */
public class L645 {
    //时间复杂度O(N)，空间复杂度O(N)
    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[10001];
        int again = 0;
        for (int i = 1; i <= nums.length; i++) {
            arr[nums[i]]++;
            if (arr[nums[i]] == 2){
                again = nums[i];
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (arr[i] == 0){
               return new int[]{again,i};

            }
        }
        return null;
    }
}

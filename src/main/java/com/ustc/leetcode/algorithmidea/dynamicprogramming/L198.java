package com.ustc.leetcode.algorithmidea.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

/**
 *  198. 打家劫舍
 *  https://leetcode-cn.com/problems/house-robber/
 */
public class L198 {
    /**
     * 递归解法
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        return rob(nums,nums.length - 1);
    }

    private int rob(int[] nums, int n) {
        if (n == 0){
            return nums[0];
        }
        if (n == 1){
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int a1 = rob(nums,n-1);
        int a2 = rob(nums,n-2) + nums[n];
        return a1> a2 ? a1 : a2;
    }

    /**
     * 动态规划解法
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int[] table = new int[nums.length];
        table[0] = nums[0];
        table[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 2; i < nums.length; i++) {
            table[i] = table[i-1] > table[i-2] + nums[i] ? table[i-1] : table[i-2] + nums[i];
        }

        return table[table.length - 1];
    }


    @Test
    public void tests(){
        int[] arr = new int[]{5,2,3,7};
        int[] arr1 = new int[]{5};
        int[] arr2 = new int[]{5,2};
        int[] arr3 = new int[]{2,7,9,3,1};
        rob(arr3);
        Assert.assertEquals(12,rob(arr));
        Assert.assertEquals(5,rob(arr1));
        Assert.assertEquals(5,rob(arr2));
        Assert.assertEquals(12,rob(arr3));
    }
}

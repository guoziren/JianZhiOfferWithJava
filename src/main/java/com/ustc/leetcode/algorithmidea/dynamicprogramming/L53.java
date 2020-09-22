package com.ustc.leetcode.algorithmidea.dynamicprogramming;

/**
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class L53 {
    /**
     * 找出连续子序和最大，求出所有以i结尾连续子序和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
             pre = Math.max(pre + nums[i],nums[i]);
             max = Math.max(pre, max);
        }
        return max;
    }
}

package com.ustc.leetcode.algorithmidea.dynamicprogramming;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 300. 最长递增子序列
 */
public class L300 {
    public int lengthOfLIS(int[] nums) {
        int[] f = new int[nums.length];
        f[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    f[i] = f[j] + 1 > f[i] ? f[j] + 1 : f[i];
                }
            }
            if (f[i] == 0) {
                f[i] = 1;
            }
            if (f[i] > max) {
                max = f[i];
            }
        }
        return max;
    }

}

package com.ustc.leetcode.algorithmidea.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

/**
 *  494. 目标和
 *  https://leetcode-cn.com/problems/target-sum/
 */
public class L494 {
    /**
     *
     * @param nums 非负整数数组，数组非空，长度不超过20 ，初始数组的和不超过1000
     * @param S 目标和
     * @return 进行加减得到目标和的方法数
     */
    public int findTargetSumWays(int[] nums, int S) {
        int max = 1000;
        if (S > max || S < -1 * max) {
            return 0;
        }

        int len = max * 2 + 1; // 和的范围 [-1000,+1000]
        int[][] dp = new int[nums.length][len];
        // 初始化第一行
        dp[0][max + nums[0]] += 1;
        dp[0][max - nums[0]] += 1; // 这里得是+= , 因为第一个数为0时， 正0 和 负0 算2种
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < len; j++) {
                if (j - nums[i] >= 0 ){
                    dp[i][j] += dp[i-1][j - nums[i]];
                }
                if (j + nums[i] < len) {
                    dp[i][j] += dp[i-1][j + nums[i]];
                }
            }
        }
        return dp[nums.length - 1][S + max];
    }

    /**
     * 时间 空间优化
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays2(int[] nums, int S) {

        int max = 0;
        for (int num : nums) {
            max += num;
        }
        if (S > max || S < -1 * max) {
            return 0;
        }
        int len = max * 2 + 1; // 和的范围 [-1000,+1000]
        int[][] dp = new int[nums.length][len];
        // 初始化第一行
        dp[0][max + nums[0]] += 1;
        dp[0][max - nums[0]] += 1; // 这里得是+= , 因为第一个数为0时， 正0 和 负0 算2种
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < len; j++) {
                if (j - nums[i] >= 0 ){
                    dp[i][j] += dp[i-1][j - nums[i]];
                }
                if (j + nums[i] < len) {
                    dp[i][j] += dp[i-1][j + nums[i]];
                }
            }
        }
        return dp[nums.length - 1][S + max];
    }


    @Test
    public void test(){
        L494 l494 = new L494();
        int[] nums = new int[]{1,1,1,1,1};
        int s = 3;
        Assert.assertEquals(5,l494.findTargetSumWays(nums, s));

        nums = new int[]{0,0,0,0,0,0,0,0,1};
        s = 1;
        Assert.assertEquals(256,l494.findTargetSumWays(nums, s));
    }

}

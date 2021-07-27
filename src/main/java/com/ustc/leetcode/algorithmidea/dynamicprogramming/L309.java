package com.ustc.leetcode.algorithmidea.dynamicprogramming;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 309. 最佳买卖股票时机含冷冻期
 */
public class L309 {
    public int maxProfit(int[] prices) {
        // 此题不只求一个函数，是求3个函数 f(n,0) f(n,1) f(n,2) , 然后求这3者的最大值
        // f[i][0] 第i天结束后的最大收益，持有股票， 可卖
        // f[i][1] 第i天结束后的最大收益，不持有股票，处于冷冻期
        // f[i][2] 第i天结束后的最大收益，不持有股票，不处于冷冻期，可买
        // f[i][0] = max(f[i-1][0], f[i-1][2] - prices[i])
        // f[i][1] = f[i-1][0] + prices[i]
        // f[i][2] = max(f[i-1][2], f[i-1][1])
        int len = prices.length;
        if (len == 0 || len == 1) {
            return 0;
        }
        int[][] f = new int[len][3];
        f[0][0] = -1 * prices[0];
        f[0][1] = 0;
        f[0][2] = 0;
        for (int i = 1; i < len; i++) {
            f[i][0] =  Math.max(f[i-1][0], f[i-1][2] - prices[i]);
            f[i][1] = f[i-1][0] + prices[i];
            f[i][2] = Math.max(f[i-1][2], f[i-1][1]);
        }
        return Math.max(f[len - 1][1], f[len - 1][2]);
    }
}

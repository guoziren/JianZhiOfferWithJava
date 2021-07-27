package com.ustc.leetcode.algorithmidea.dynamicprogramming;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 714. 买卖股票的最佳时机含手续费
 */
public class L714 {
    /**
     * 参考L122
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len == 1) {
            return 0;
        }
        int[][] f = new int[len][2];
        // f[i][0]  表示第i天结束后的最大收益，第i天结束后可买
        // f[i][0]  表示第i天结束后的最大收益，第i天结束后可卖
        f[0][0] = 0;
        f[0][1] = -1 * prices[0];
        for (int i = 1; i < len; i++) {
            f[i][0] = Math.max(f[i-1][0], f[i-1][1] + prices[i] - fee);
            f[i][1] = Math.max(f[i-1][1], f[i-1][0] - prices[i]);
        }
        return Math.max(f[len - 1][0], f[len -1][1]);
    }
}

package com.ustc.leetcode.algorithmidea.dynamicprogramming;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class L121 {
    int max = Integer.MIN_VALUE;

    /**
     * int maxProfit(int[] prices, int n) 返回前面最小数的索引
      * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2){
            return 0;
        }
         maxProfit(prices,prices.length - 1);
         if (max < 0){
             return 0;
         }else {
             return max;
         }
    }

    private int maxProfit(int[] prices, int n) {
        if (n == 0){
            return 0;
        }
        int minIndex = maxProfit(prices,n-1);
        int cur = prices[n] - prices[minIndex];
        max = Math.max(cur,max);
        if (cur < 0){
            return n;
        }else{
            return minIndex;
        }
    }


    /**
     * 动态规划
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int minIndex = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[minIndex]){
                minIndex = i;
            }
            max = Math.max(prices[i] - prices[minIndex],max);
        }
        return max < 0 ? 0 : max;
    }
}

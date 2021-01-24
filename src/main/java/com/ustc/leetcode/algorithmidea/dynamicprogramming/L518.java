package com.ustc.leetcode.algorithmidea.dynamicprogramming;

/**
 * 518. 零钱兑换 II
 * https://leetcode-cn.com/problems/coin-change-2/
 */
public class L518 {
    /**
     * 结合爬楼梯问题
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        int[] f = new int[amount + 1];
        f[0] = 1;
        //排列数
//        for (int i = 1; i <= amount ; i++) {
//            for (int j = 0; j < coins.length; j++) {
//                if (coins[j] <= i) {
//                    f[i] += f[i - coins[j]];
//                }
//            }
//        }
        // 组合数
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i >= coin) {
                    f[i] += f[i - coin];
                }
            }
        }
        return f[amount];


    }
}

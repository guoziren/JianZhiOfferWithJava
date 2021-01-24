package com.ustc.leetcode.algorithmidea.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * 322. 零钱兑换
 */
public class L322 {
    public int coinChange(int[] coins, int amount) {
       int[] f = new int[amount + 1];
        Arrays.fill(f, amount + 1);
        f[0] = 0;
       for (int i = 1; i <= amount ; i++) {
           for (int j = 0; j < coins.length; j++) {
               if (i >= coins[j]) {
                   f[i] = Math.min(f[i], f[i - coins[j]] + 1);
               }
           }
       }
        return  f[amount] > amount ? -1 : f[amount];
    }

    @Test
    public void test(){
        L322 l322 = new L322();
        int[] sample = new int[]{1, 2, 5};
        int amount = 11;
        Assert.assertEquals(3, l322.coinChange(sample,amount));

        sample = new int[]{2};
        amount = 3;
        Assert.assertEquals(-1, l322.coinChange(sample,amount));

        sample = new int[]{1};
        amount = 0;
        Assert.assertEquals(0, l322.coinChange(sample,amount));

        sample = new int[]{1};
        amount = 1;
        Assert.assertEquals(1, l322.coinChange(sample,amount));


        sample = new int[]{186,419,83,408};
        amount = 6249;
        Assert.assertEquals(20, l322.coinChange(sample,amount));
    }

}

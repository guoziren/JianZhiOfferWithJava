package com.ustc.leetcode.algorithmidea.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class L474 {
    /**
     * 1 <= strs.length <= 600
     * 1 <= strs[i].length <= 100
     * strs[i] 仅由 '0' 和 '1' 组成
     * 1 <= m, n <= 100
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for (int i = 1; i <= len; i++) {
            int[] arr = calZeroAndOne(strs[i - 1].toCharArray());
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    int zeroLen = arr[0];
                    int oneLen = arr[1];
                    if (j >= zeroLen && k >= oneLen) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeroLen][k - oneLen] + 1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }

    private int[] calZeroAndOne(char[] str) {
        int zeroLen = 0;
        int oneLen = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] - '0' == 0) {
                zeroLen++;
            } else {
                oneLen++;
            }
        }
        return new int[]{zeroLen, oneLen};
    }

    @Test
    public void test() {
        L474 l474 = new L474();
        String[] sample = new String[]{"10", "0001", "111001", "1", "0"};
        Assert.assertEquals(4, l474.findMaxForm(sample, 5, 3));
    }
}

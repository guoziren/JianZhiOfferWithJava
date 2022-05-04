package com.ustc.leetcode.algorithmidea.dynamicprogramming;

/**
 * 673. 最长递增子序列的个数
 * https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 */
public class L673 {
    public int findNumberOfLIS(int[] nums) {
        // f[i] 表示以第i个数结尾的子序列的最大长度
        int[] f = new int[nums.length];
        // g[i] 表示f[i]的个数
        int[] g = new int[nums.length];
        for (int i = 0; i < g.length; i++) {
            g[i] = 1;
        }

        f[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (f[j] + 1 > f[i]) {
                        f[i] = f[j] + 1;
                        g[i] = g[j];
                        // 这里条件得是 f[j] + 1 == f[i], 之类是关键
                    } else if (f[j] + 1 == f[i]){
                        g[i] += g[j];
                    }
                }
            }
            if (f[i] == 0) {
                f[i] = 1;
            }
            if (f[i] > max) {
                max = f[i];
            }
        }

        if (max == 1) {
            return nums.length;
        }
        // 最大长度为max， 遍历找到f(i) == max的
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (f[i] != max) {
                continue;
            }
            count += g[i];
        }
        return count;
    }
}

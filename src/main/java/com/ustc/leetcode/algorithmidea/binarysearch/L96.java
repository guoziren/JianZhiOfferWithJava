package com.ustc.leetcode.algorithmidea.binarysearch;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * 96. 不同的二叉搜索树
 */
public class L96 {
    /**
     * table[n] 即为所求，采用动态规划
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] table = new int[n + 1];
        table[0] = 1;
        table[1] = 1;
        if (n == 1) {
            return table[1];
        }

        for (int i = 2; i <= n; i++) {
            table[i] = f(i, table);
        }
        return table[n];
    }

    private int f(int n, int[] table) {
        // 以i为根，有n个数， 根不同 则结构不同
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += table[i - 1] * table[n - i];
        }
        return result;
    }
}

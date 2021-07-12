package com.ustc.leetcode.datastrcture.bitoperation;

/**
 * https://leetcode-cn.com/problems/counting-bits/
 * 338. 比特位计数
 */
public class L338 {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = countBit(i);
        }
        return result;
    }

    private int countBit(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}

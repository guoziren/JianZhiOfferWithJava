package com.ustc.leetcode.basic.other;

/**
 * 221. 最大正方形
 * https://leetcode-cn.com/problems/maximal-square/
 */
public class L221 {

    /**
     * 暴力法，找出以矩阵中每个点为左顶点能构成的最大正方形的边数, 不难
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maximalSquare = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int imalSquare = findMaxSqure(matrix, i ,j);
                if (imalSquare > maximalSquare) {
                    maximalSquare = imalSquare;
                }
            }
            // 下面这个判断大幅提升时间效率, 也提升了空间效率
            if (m - i < maximalSquare) {
                break;
            }
        }
        return maximalSquare * maximalSquare;
    }

    private int findMaxSqure(char[][] matrix, int i, int j) {
        if (matrix[i][j] == '0') {
            return 0;
        }
        for (int k = 2; k < 300; k++) {
            int row = i + k - 1;
            int col = j + k - 1;
            if (row > matrix.length - 1 || col > matrix[0].length - 1) {
                return k - 1;
            }
            for (int l = j; l < j + k; l++) {
                if (matrix[row][l] == '0') {
                    return k - 1;
                }
            }
            for (int l = i; l < i + k; l++) {
                if (matrix[l][col] == '0') {
                    return k - 1;
                }
            }
        }
        return 0;
    }
}

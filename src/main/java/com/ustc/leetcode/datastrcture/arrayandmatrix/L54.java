package com.ustc.leetcode.datastrcture.arrayandmatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 * 54. 螺旋矩阵
 */
public class L54 {

    /**
     * 思路：正常解法，画几个测试用例，手动走一遍，分别列出多种情况分别该怎么走
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // m,n >= 1
        int row = matrix.length;
        ;
        int col = matrix[0].length;

        boolean[][] visited = new boolean[row][col];

        boolean isTraverseFinish = false;
        int i = 0, j = 0;
        boolean isRightHasVisited = false;
        boolean isDownHasVisited = false;
        boolean isLeftHasVisited = false;
        boolean isUpHasVisited = false;
        List<Integer> list = new ArrayList<>();
        while (true) {
            // 往右
            for (; j < col; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    isRightHasVisited = true;
                    list.add(matrix[i][j]);
                }else {
                    j--; // 这里回退是关键
                    break;
                }
            }
            if (j >= col) {
                j--;
            }
            i++;

            // 超出边界： 换下一个方向
            // 未访问， 一直走下去
            // 已访问， 跳出

            // 往下
            for (; i < row; i++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    isDownHasVisited = true;
                    list.add(matrix[i][j]);
                }else {
                    i--;
                    break;
                }
            }
            if (i >= row) {
                i--;
            }
            j--;

            // 往左
            for (; j >= 0; j--) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    list.add(matrix[i][j]);
                    isLeftHasVisited = true;
                }else {
                    j++;
                    break;
                }
            }
            if (j < 0) {
                j++;
            }
            i--;


            // wang上
            for (; i >= 0; i--) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    list.add(matrix[i][j]);
                    isUpHasVisited = true;
                } else {
                    i++;
                    break;
                }
            }
            if (i < 0) {
                i++;
            }
            j++;


            if (!isDownHasVisited && !isLeftHasVisited && !isRightHasVisited && !isUpHasVisited) {
                break;
            }
            isRightHasVisited = false;
            isDownHasVisited = false;
            isLeftHasVisited = false;
            isUpHasVisited = false;
        }
        return list;

    }

}

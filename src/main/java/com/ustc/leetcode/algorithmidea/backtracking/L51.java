package com.ustc.leetcode.algorithmidea.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 * 51. N 皇后
 */
public class L51 {
    /**
     * 回溯用于解决排列 组合 切割  子集问题， 某些表面是矩阵的也可以
     * 题目没说清楚， 不仅不能位于同一行 或者同一列，同一对角线都是不行的
     * 采用回溯， 深度优先遍历
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        // 初始化为空位
        char[][] chess = new char[n][n];
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                chess[i][j] = '.';
            }
        }

        List<List<String>> result = new ArrayList<>();
            solveNQueens( 0, result, n, chess);
            return result;
    }

    /**
     *
     * @param row 当前行
     * @param result 结果集合
     * @param column 列的长度，也是行的长度
     * @param chess 构造的棋盘
     */
    private void solveNQueens( int row, List<List<String>> result, int column, char[][] chess) {
        if (row == column) {
           addOne(result, chess);
            return;
        }

        for (int j = 0; j < column; j++) {
            // 如果是有效的到下层
            chess[row][j] = 'Q';
            if(isValid(row, j, chess)) {
                solveNQueens(row + 1, result, column, chess);
            }
            chess[row][j] = '.';
        }
    }

    private boolean isValid(int row, int column, char[][] chess) {

        // 判断上边, 因为是从上面的行往下找的，不用判断下边
        for (int i = row - 1; i >= 0 ; i--) {
            if (chess[i][column] == 'Q') {
                return false;
            }
        }

        // 判断左上对角线
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0 ; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        // 判断左下对角线
        for (int i = row + 1, j = column - 1; i < chess.length && j >= 0 ; i++, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        // 判断右下对角线
        for (int i = row + 1, j = column + 1; i < chess.length && j < chess.length ; i++, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        // 判断右上对角线
        for (int i = row - 1, j = column + 1; i >= 0 && j < chess.length ; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private void addOne(List<List<String>> result, char[][] chess) {
        List<String> one = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            String s = new String(chess[i]);
            one.add(s);
        }
        result.add(one);
    }
}

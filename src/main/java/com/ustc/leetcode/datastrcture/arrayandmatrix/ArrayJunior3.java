package com.ustc.leetcode.datastrcture.arrayandmatrix;



/**
 * 有效的数独
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2f9gg/
 */
public class ArrayJunior3 {
    public boolean isValidSudoku(char[][] board) {
        // 定义一个三维数字, 一维(从左到右，一维二维三维)表示哪个数字，二维的0表示行，1表示列，三维表示第几行或者列
        // table[0][1][2] 表示数字1在第3列出现的次数
        //
        int[][][] table = new int[9][2][9];
        // 数字 1-9 在每一行只能出现一次。
        // 数字 1-9 在每一列只能出现一次。
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                table[num - 1][0][i]++;
                table[num - 1][1][j]++;
                if (table[num - 1][0][i] > 1 || table[num - 1][1][j] > 1) {
                    return false;
                }
            }
        }
        // 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次
       boolean r1 = isValidSudoku(board, 0,2,0,2);
       boolean r2 = isValidSudoku(board, 0,2,3,5);
       boolean r3 = isValidSudoku(board, 0,2,6,8);
       boolean r4 = isValidSudoku(board, 3,5,0,2);
       boolean r5 = isValidSudoku(board, 3,5,3,5);
       boolean r6 = isValidSudoku(board, 3,5,6,8);
       boolean r7 = isValidSudoku(board, 6,8,0,2);
       boolean r8 = isValidSudoku(board, 6,8,3,5);
       boolean r9 = isValidSudoku(board, 6,8,6,8);
       return r1 && r2 && r3 && r4 && r5 && r6 && r7 && r8 && r9;

    }

    private boolean isValidSudoku(char[][] board, int iStart, int iEnd, int jStart, int jEnd) {
        int[] array = new int[9 + 1];
        for (int i = iStart; i <= iEnd; i++) {
            for (int j = jStart; j <= jEnd; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                array[num]++;
                if (array[num] > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}

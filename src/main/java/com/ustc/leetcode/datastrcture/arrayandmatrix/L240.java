package com.ustc.leetcode.datastrcture.arrayandmatrix;

/**
 *  https://leetcode-cn.com/problems/search-a-2d-matrix-ii/description/
 *  240. 搜索二维矩阵 II
 */
public class L240 {
    //时间复杂度O(m + n),空间复杂度O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0){
            return false;
        }
        int col = matrix[0].length;
        int i = 0,j = col - 1;
        for (;i < row && j >= 0;){
            if (matrix[i][j] > target){
                j--;
            }else if(matrix[i][j] < target){
                i++;
            }else {
                return true;
            }
        }
        return false;
    }
}

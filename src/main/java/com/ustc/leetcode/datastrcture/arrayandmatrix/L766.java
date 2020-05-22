package com.ustc.leetcode.datastrcture.arrayandmatrix;

import org.junit.Test;

/**
 *  766. 托普利茨矩阵
 *  https://leetcode-cn.com/problems/toeplitz-matrix/description/
 */
public class L766 {
    //时间复杂度O(M * N),空间复杂度O(1)
    //遍历顺序外层  第一列，从下到上，然后第一行第二个->第一行最后一个；
    //       内层按右下对角线的顺序比较
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = m - 1; i >= 0 ; i--) {
            int pre = matrix[i][0];
            for (int k = i + 1,j = 1; j <= n - 1 && k <= m - 1; j++,k++) {
                if (matrix[k][j] != pre){
                    return false;
                }else{
                    pre = matrix[k][j];
                }
            }
        }
        for (int j = 1; j <= n - 1;j++) {
            int pre = matrix[0][j];
            for (int i = 1,k = j + 1 ; i <= m - 1 && k <= n - 1; i++,k++) {
                if (matrix[i][k] != pre){
                    return false;
                }else{
                    pre = matrix[i][k];
                }
            }
        }
        return true;
    }
    @Test
    public void test(){
//        int[][] matrix = {{1,2},{2,2}};
        int[][] matrix = {{1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}};

        System.out.println(isToeplitzMatrix(matrix));
    }

}

package com.ustc.interview.problem29;

import org.junit.Test;

import java.util.ArrayList;

public class InterviewProblem29_1 {
    @Test
    public void test(){
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8}};
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list);
    }
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return list;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        while (2 * start < rows && 2 * start < cols){
            printOneCircle(matrix,start,list,rows,cols);
            start++;
        }
        return list;
    }

    private void printOneCircle(int[][] matrix, int start, ArrayList<Integer> list, int rows, int cols) {
        //横
        int begin_row = start;
        int end_row = rows - 1 - start;
        int begin_col = start;
        int end_col = cols - 1 - start;
        //从左到右
        for (int i = start; i < cols - start; i++) {
            int temp = matrix[start][i];
            list.add(temp);
        }

        //从上到下
        //如果只有1行，
      //  if (begin_row < end_row){
            for (int i = start + 1; i <= end_row; i++) {
                int temp = matrix[i][end_col];
                list.add(temp);
            }
    //    }

        //从右到左
        if(begin_col < end_col && begin_row < end_row){
            for (int i = end_col - 1; i >= begin_col ; i--) {
                int temp = matrix[end_row][i];
                list.add(temp);
            }
        }


        //从下到上
        if (begin_col < end_col && begin_row < end_row){
            for (int i = end_row - 1; i >= begin_row + 1 ; i--) {
                int temp = matrix[i][begin_col];
                list.add(temp);
            }
        }
    }
}

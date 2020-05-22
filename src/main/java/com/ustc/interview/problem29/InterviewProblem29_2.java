package com.ustc.interview.problem29;

import org.junit.Test;

import java.util.ArrayList;

//此解法在牛客网上超时
public class InterviewProblem29_2 {
    static int size ;
    private ArrayList list;

    @Test
    public void test(){
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8}};
        list = printMatrix(matrix);
        System.out.println(list);
    }
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return list;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0,right = cols - 1,top = 0,down = rows - 1;
         size = rows * cols;
        while (size > 0){
            leftToRight(matrix,left,right,top);
            top++;
            upToDown(matrix,down,top,right);
            right--;
            rightToleft(matrix,left,right,down);
            down--;
            downToUp(matrix,down,top,down);
            left++;
        }

        return list;
    }
    private void leftToRight(int[][] matrix,int left,int right,int row){
        if (left > right){
            return;
        }
        for (int i = left; i <= right  ; i++) {
            size--;
            list.add(matrix[row][i]);
        }
    }
    private void rightToleft(int[][] matrix,int left,int right,int row){
        if (left > right){
            return;
        }
        for (int i = right; i >= left  ; i--) {
            size--;
            list.add(matrix[row][i]);
        }

    }
    private void downToUp(int[][] matrix,int down,int top,int col){
        if (top > down){
            return;
        }
        for (int i = down; i >= down  ; i--) {
            size--;
            list.add(matrix[i][col]);
        }
    }
    private void upToDown(int[][] matrix,int down,int top,int col){
        if (top > down){
            return;
        }
        for (int i = top; i <= down  ; i++) {
            size--;
            list.add(matrix[i][col]);
        }
    }
}

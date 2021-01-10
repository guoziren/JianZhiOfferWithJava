package com.ustc;


import org.junit.Test;

import java.sql.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main{
    public int movingCount(int threshold, int rows, int cols)
    {
        
        boolean[] visited = new boolean[rows * cols];
      return movedCount(threshold,rows,cols,0,0,visited);
    }
    public int getSum(int q1,int q2){
        String s1 = String.valueOf(q1);
        String s2 = String.valueOf(q2);
        int sum = 0;
        for(int i = 0;i < s1.length();i++){
            sum += s1.charAt(i) - '0';
        }
        for(int i = 0;i < s2.length();i++){
            sum += s2.charAt(i) - '0';
        }
        return sum;
    }
    public int movedCount(int threshold, int rows, int cols,int row,int col,boolean[] visited){
        if (row > rows - 1 || row < 0 || col < 0 || col > cols - 1){
            return 0;
        }
        if (getSum(row,col) > threshold){
            return 0;
        }
        if (visited[row * cols + col]){
            return 0;
        }
        visited[row * cols + col] = true;
        int res = movedCount(threshold,rows,cols,row,col + 1,visited)+
               // movedCount(threshold,rows,cols,row,col -1)+
                movedCount(threshold,rows,cols,row + 1,col,visited)+ 1;
               // movedCount(threshold,rows,cols,row - 1,col + 1) + 1;
        return res;
    }
    @Test
    public void test() throws SQLException {

    }
}

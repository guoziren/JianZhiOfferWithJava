package com.ustc.interview.problem12;

import org.junit.Test;

public class InterviewProblem {

        public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
            int index = 0;
            boolean[] visited = new boolean[rows * cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if(hasPathCore(matrix,rows,cols,i,j,str,index,visited)){
                        return true;
                    }
                }
            }
            return false;
        }

    private boolean hasPathCore(char[] matrix, int rows, int cols, int i, int j, char[] str, int index,boolean[] visited) {
            if (i < 0 || j < 0){
                return false;
            }
            boolean hasPath = false;
            if (i < rows && j < cols && matrix[i * cols + j] == str[index] && !visited[i * cols + j]){
                if (index == str.length - 1){
                    return true;
                }
                index++;
                visited[i * cols + j] = true;
                hasPath = hasPathCore(matrix,rows,cols,i,j - 1,str,index,visited)||//左
                        hasPathCore(matrix,rows,cols,i - 1,j,str,index,visited)||//上
                        hasPathCore(matrix,rows,cols,i ,j + 1,str,index,visited)||//右
                        hasPathCore(matrix,rows,cols,i + 1,j,str,index,visited);//下
                if (!hasPath){//回退
                    index--;
                    visited[i * cols + j] = false;//?
                }

            }
            return hasPath;
    }

    @Test
        public void test(){
            char[] matrix = "abcesfcsadee".toCharArray();
            int rows = 3,cols = 4;
            char[] str = "abcb".toCharArray();
            boolean res = hasPath(matrix,rows,cols,str);
            System.out.println(res);
        }

}

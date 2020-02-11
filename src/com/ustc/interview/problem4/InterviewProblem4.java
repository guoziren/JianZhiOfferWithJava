package com.ustc.interview.problem4;

/**
 * 面试题4：二维数组中的查找
 */
public class InterviewProblem4 {
    private static int test[][] = {{1,2,8,9},
                            {2,4,9,12},
                            {4,7,10,13},
                            {6,8,11,15}};
    public static void main(String[] args) {
        //包含查找的数字
        find(test,4,4,1);
        find(test,4,4,15);
        find(test,4,4,7);
        //没有查找的数字
        find(test,4,4,-1);
        find(test,4,4,20);
        find(test,4,4,14);
        //传入null
        find(null,4,4,14);
    }

    /**
     * 查找number是否在矩阵matrix中
     * @param matrix 待查矩阵
     * @param rows 矩阵的行数
     * @param columns 矩阵的列数
     * @param number 要查找的数
     * @return
     */
    public static boolean find(int matrix[][],int rows,int columns,int number){
        boolean found  = false;

        if (matrix != null && rows > 0 && columns > 0){
            //从第零行最右边一列开始,往左下角扫描
            int row = 0;
            int column = columns - 1;
            while (row < rows && column >= 0){
                if (matrix[row][column] == number){
                    found = true;
                    break;
                }else if(matrix[row][column] > number){
                    column--;
                }else{
                    row++;
                }
            }
        }
        System.out.println(found);
        return found;
    }
}

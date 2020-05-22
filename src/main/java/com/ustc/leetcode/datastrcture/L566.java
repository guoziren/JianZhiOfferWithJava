package com.ustc.leetcode.datastrcture;

import org.junit.Test;

/**
 * 566. 重塑矩阵
 * https://leetcode-cn.com/problems/reshape-the-matrix/
 */
public class L566 {
    //时间上只击败了63.47%,官方最好的解法也是这个数据
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int col = nums[0].length;
        int len = nums.length * col;
        if (len != r * c){
            return nums;
        }
        if (col == c && nums[0].length == r){
            return nums;
        }

        int[][] result = new int[r][c];
        int m = 0,n = 0;
        int x = 0,y = 0;
        for (int i = 0; i < len; i++) {
           result[m][n] = nums[x][y];
           n++;
           y++;
           if (n == c ){
               n = 0;
               m++;
           }
           if (y == col){
               y = 0;
               x++;
           }
        }

        return result;
    }
    @Test
    public void test(){
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9,10}};
        System.out.println(nums.length);
        System.out.println(nums[0].length);
        System.out.println(nums[1].length);
        System.out.println(nums[3].length);
//        for (int i = 0; i < nums; i++) {
//            for (int j = 0; j < ; j++) {
//
//            }
//        }
    }
}

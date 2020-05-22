package com.ustc.leetcode.datastrcture.arrayandmatrix;

/**
 *  283. 移动零
 */
public class L283 {
    //时间复杂度O(N),空间复杂度O(1)
    public void moveZeroes(int[] nums) {
        int countForZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                countForZero++;
            }else{
                nums[i - countForZero] = nums[i];
            }
        }
        for (int i = nums.length - 1; countForZero > 0 ; i--,countForZero--) {
            nums[i] = 0;
        }
    }
}

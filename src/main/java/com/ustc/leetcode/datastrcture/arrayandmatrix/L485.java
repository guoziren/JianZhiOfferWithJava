package com.ustc.leetcode.datastrcture.arrayandmatrix;

/**
 *  485. 最大连续1的个数
 *  https://leetcode-cn.com/problems/max-consecutive-ones/
 */
public class L485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int longest = -1;
        for (int num : nums) {
            if (num == 1){
                count++;
            }else{
                longest = count > longest ? count : longest;
                count = 0;
            }
        }
        return longest;
    }
}

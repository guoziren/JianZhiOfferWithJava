package com.ustc.leetcode.algorithmidea.doublepointer;

import java.util.Arrays;
import java.util.Collections;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 * 75. 颜色分类
 */
public class L75 {
    /**
     * 考的什么，不是实现教科书上的排序，题目仅有0，1，2 ，
     * 可交换2次，第1次把所有的0交换到前面，然后交换1。
     * 上面的遍历了2次，仅用1次 便是考察双指针的用法
     * @param nums
     */
    public void sortColors(int[] nums) {
        if (1 == nums.length) {
            return;
        }
        int p0 = 0, p1 = 0;
        if (nums[0] == 0) {
            p0++;
            p1++;
        }
        if (nums[0] == 1) {
            p1++;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, p1);
                p1++;
            }
            if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 == p1) {
                    p1++;
                }
                p0++;
                if (nums[i] == 1) {
                    swap(nums, i, p1);
                    p1++;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

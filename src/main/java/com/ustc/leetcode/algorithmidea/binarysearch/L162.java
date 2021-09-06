package com.ustc.leetcode.algorithmidea.binarysearch;

/**
 * https://leetcode-cn.com/problems/find-peak-element/
 * 162. 寻找峰值
 */
public class L162 {

    //  1 2 3 4 5       3, 4 5        4     5  -> 5
    //  5 4 3 2 1       3, 5,4,3      4 ,   5,4  5

    // 2 3 5 4 1        2,3,5      3  5

    /**
     * 递增 递减的性质，讨论3种情况
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }
    public int find(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return find(nums, l, mid);
        return find(nums, mid + 1, r);
    }
}

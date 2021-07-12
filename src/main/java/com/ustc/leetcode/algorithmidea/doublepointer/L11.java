package com.ustc.leetcode.algorithmidea.doublepointer;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 11. 盛最多水的容器
 */
public class L11 {
    /**
     * 遍历法计算两两之间的面积/容量会超时
     * 双指针法， 面积 = 2条线的距离 * 2个线高度的较小者
     * 较小的移动，因为如果是较大的移动，因为距离是变小的，  2个线高度的较小者 不会变大
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = -1;
        while (left < right) {
            int width = right - left;
            int h = height[left] > height[right] ? height[right] : height[left];
            int area = width * h;
            if (area > maxArea) {
                maxArea = area;
            }
            if (h == height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}

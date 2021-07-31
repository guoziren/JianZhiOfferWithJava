package com.ustc.leetcode.basic.other;

public class L42 {

    /**
     * 本题关键是要***读懂题意：
     * 下标i处水能达到的最大高度等于2边最大高度的较小值，
     * 下标i处的容量 =下标i处水能达到的最大高度 - height[1]
     *
     * 平凡的方法是对于每个下标i，左右各扫描找出2边最大值，O(n), 下标有n个 就是O(n方)
     * 下标2边的最大值能不能存起来，答：能。 此题特别之处，构造2个辅助数组
     * leftmax(i) = max(leftmax(i-1), heght(i));   从左往右扫描
     * rightmax(i) = max(rightmax(i + 1), height(i))  从右往左扫描
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        // 动态规划 辅助数组
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            int capacity = Math.min(leftMax[i], rightMax[i]);
            result = result + capacity - height[i];
        }
        return result;
    }

    /**
     * 此法超出内存限制， height数组长度 最大为3 * 10的4次方， 单个height最大为10的5,10的9次方个int超出内存限制
     * 算法思想： 构造二维数组， 左右2边找有没有可挡住的
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        if (height == null || height.length == 0 || height.length == 1) {
            return 0;
        }
        int width = height.length;
        int maxHeight = -1;
        for (int i : height) {
            if (i > maxHeight) {
                maxHeight = i;
            }
        }
        int[][] array = new int[maxHeight][width];
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            for (int j = 0; j < h; j++) {
                array[maxHeight - 1 - j][i] = 1;
            }
        }
        int result = 0;
        for (int i = 0; i < array.length; i++) { //行
            for (int j = 0; j < width; j++) { // 列
                if (array[i][j] != 1 && isValid(i,j,array)) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isValid(int i, int j, int[][] array) {
        // 左边
        boolean flag = false;
        for (int k = j - 1; k >= 0; k--) {
            if (array[i][k] == 1) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return false;
        }
        //右边
        flag = false;
        for (int k = j + 1; k < array[0].length; k++) {
            if (array[i][k] == 1) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}

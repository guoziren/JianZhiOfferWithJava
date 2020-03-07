package com.ustc.leetcode.algorithmidea.binarysearch;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 153. 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/description/
 */
public class L153 {
    //此题假设不存在重复元素，重复元素的怎么做？
    public int findMin(int[] nums) {
        int len = nums.length;
        if (nums[0] < nums[len - 1] || len == 1){
            return nums[0];
        }

        int low = 0;
        int high = len - 1;
        /**
         * 在这个改进版本的二分搜索算法中，我们需要找到这个点。下面是关于变化点的特点：
         *所有变化点左侧元素 > 数组第一个元素
         *所有变化点右侧元素 < 数组第一个元素
         *
         */
        while (low <= high){
            int mid = (low + high) >>> 1;
            if (nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }

            if (mid > 0 && nums[mid - 1] > nums[mid]){
                return nums[mid];
            }
            if(nums[mid] <= nums[len - 1] ){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return nums[low];
    }
    @Test
    public void tests(){
        for (int i = 0; i < 5000; i++) {
            int[] nums = generateRandomRotationArray(10,8);

            int a = findMin(nums);
            int b = absoluteRight(nums);
            if (a != b){
                System.out.println(false);
                return;
            }
        }
        System.out.println("true");

    }
    private int[] generateRandomRotationArray(int maxSize,int maxVal){
        LinkedList<Integer> list = new LinkedList<>();
        int realSize = (int)(maxSize * Math.random()) + 1;
        for (int i = 0; i < realSize; i++) {
            list.addLast((int)((maxVal + 1) * Math.random()));
        }
        Collections.sort(list);
        //选转
        int count = (int)(16 * Math.random());
        for (int i = 0; i < count; i++) {
            int first = list.removeFirst();
            list.addLast(first);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
    public int absoluteRight(int[] nums){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min){
                min = nums[i];
            }
        }
        return min;
    }

}

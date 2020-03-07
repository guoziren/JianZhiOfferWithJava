package com.ustc.leetcode.algorithmidea.binarysearch;

import com.ustc.zuoshen.util.Duishuqi;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class L34 {
    public int[] searchRange(int[] nums, int target) {

        int r1 =  searchLeftEdge(nums,  target);
        int r2 =  searchRightEdge(nums,  target);
        return new int[]{r1,r2};
    }
    //找右边界
    private int searchRightEdge(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = (low + high) >>> 1;
            if (nums[mid] > target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        if ( target != nums[high] && target != nums[low] ){
            return -1;
        }
        return high;
    }
    //找左边界
    private int searchLeftEdge(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = (low + high) >>> 1;
            if (nums[mid] >= target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        if (target != nums[low] && target != nums[high]){
            return -1;
        }
        return low;
    }


}

package com.ustc.leetcode.datastrcture.hashtable;

import com.sun.tools.javac.util.List;
import org.junit.Test;

import java.util.Arrays;

/**
 * 两数之和
 */
public class L1 {
    @Test
    public void test(){
        int arr[] = {3,2,4};
        int res[] = twoSum(arr,6);
        System.out.println(res[0] + " " + res[1]);
    }
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int n = nums[i] + nums[j];
                if( n == target){
                    return new int[]{i,j};
                }else if(n > target){
                    break;
                }
            }
        }
        return null;
    }

    /**
     * 方法二：哈希表法   时间复杂度O(n) 空间复杂度O(n)
     * @return
     */
    public int[] twoSum(){
        return null;
    }
}

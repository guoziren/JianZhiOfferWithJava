package com.ustc.leetcode.datastrcture.arrayandmatrix;

import org.junit.Test;

import java.util.*;

/**
 * 697. 数组的度
 * https://leetcode-cn.com/problems/degree-of-an-array/
 */
public class L697 {
    //时间上 击败了80+%  ,官方解法只有70+; 时间复杂度O(n)，空间复杂度O(n)
    public int findShortestSubArray(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        HashSet<Integer> set= new HashSet<>();
        int[] arr = new int[50000];
        int max = 0;//数组的度
        
        for (int num : nums) {
            arr[num]++;
            if (arr[num] > max){
                max = arr[num];
            }
        }

        HashMap<Integer,Data> map = new HashMap<>();
        //所有个数为max的数加入到map
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max){
                map.put(i,new Data(-1,-1));
            }
        }
        //遍历找出left和right位置
        for (int i = 0; i < nums.length; i++) {

               if (map.containsKey(nums[i]) && map.get(nums[i]).lIndex == -1){
                   map.get(nums[i]).lIndex = i;
                   map.get(nums[i]).rIndex = i;
               }else if(map.containsKey(nums[i]) ){
                   map.get(nums[i]).rIndex = i;
               }

        }
        //计算最小的子数组长度
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Data> integerDataEntry : map.entrySet()) {
            Data d = integerDataEntry.getValue();
            min = Math.min(d.rIndex - d.lIndex + 1,min);
        }
        return min;
    }
    class Data {

        int lIndex;
        int rIndex;

        public Data( int lIndex, int rIndex) {

            this.lIndex = lIndex;
            this.rIndex = rIndex;
        }
    }
    @Test
    public void test(){
      int[] arr = {1,2,2,3,1,4,2};
     int res = findShortestSubArray(arr);
        System.out.println(res);
    }

}

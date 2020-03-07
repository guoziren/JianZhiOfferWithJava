package com.ustc.leetcode.datastrcture.hashtable;

import java.util.HashSet;

/**
 * 217. 存在重复元素
 * https://leetcode-cn.com/problems/contains-duplicate/description/
 */
public class L217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
          if (set.contains(nums[i])){
              return true;
          }else{
              set.add(nums[i]);
          }
        }
        return false;
    }
}

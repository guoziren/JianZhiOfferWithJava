package com.ustc.leetcode.algorithmidea.math;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * 448. 找到所有数组中消失的数字
 */
public class L448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] arr = new int[nums.length + 1];
        for (int num : nums) {
            arr[num]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}

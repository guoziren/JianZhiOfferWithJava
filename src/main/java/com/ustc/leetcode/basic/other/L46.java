package com.ustc.leetcode.basic.other;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/submissions/
 * 46. 全排列
 */
public class L46 {
    /**
     * 1        1
     * 2        21 12
     * 3        321 231 213 312 132 123
     * 自底向上，n个数的所有排列 在n-1个数的排列的n个位置 插入第n个数得到
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<List<Integer>> pre = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        pre.add(temp);
        result = pre;
        for (int i = 1; i < nums.length; i++) {
            // 对每个排列
            result = new ArrayList<>();
            for (List<Integer> integers : pre) {
                // 插入integer的长度+1位置
                for (int j = 0; j < integers.size() + 1; j++) {
                    List<Integer> copy = new ArrayList<>(integers);
                    copy.add(j, nums[i]);
                    result.add(copy);
                }
            }
            pre = result;
        }
        return result;
    }
}

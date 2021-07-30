package com.ustc.leetcode.algorithmidea.backtracking;

import java.util.*;

public class L491 {
    /**
     * ！！1. 该题不能对数组排序，因为改变顺序后 得到的子序列就不是原来序列的子序列
     * 2.不用visited数组， dfs时， 索引+1替代
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return result;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        // 先找子序列长度为2的，递增
        for (int sublen = 2; sublen <= nums.length; sublen++) {
            // 从第一个元素开始
            dfs(nums, sublen, 1, result, stack, 0);
        }
        return result;

    }

    /**
     *
     * @param nums 原数组
     * @param len 要找的子序列的长度
     * @param height 当前高度， 根为1
     * @param result 结果集合
     * @param stack 辅助栈
     * @param begin 遍历开始的索引，开始0，下一次就是从1后开始
     */
    private void dfs(int[] nums, int len, int height, List<List<Integer>> result, LinkedList<Integer> stack, int begin) {
        if (height > len) {
            return;
        }
        // 记录当前层已经访问过的数，后面碰到相同的则跳过(剪枝)
        Set<Integer> currentLevelNumVisited = new HashSet<>();
        for (int i = begin; i < nums.length; i++) {
            if (!stack.isEmpty() && stack.peek() > nums[i]) {
                continue;
            }
            if (currentLevelNumVisited.contains(nums[i])) {
                continue;
            }
            currentLevelNumVisited.add(nums[i]);
            stack.push(nums[i]);
            if (height == len) {
                addOne(stack, result);
            }
            dfs(nums, len, height + 1, result, stack, i + 1);
            stack.pop();
        }
    }

    /**
     * 找到一个结果，添加仅结果集合中
     * eg: stack [6,4] 说明4是根， 逆序添加进结果集合中
     * @param stack
     * @param result
     */
    private void addOne(LinkedList<Integer> stack, List<List<Integer>> result) {
        List<Integer> list = new ArrayList<>();
        // 反向遍历
        ListIterator<Integer> iterator = stack.listIterator(stack.size());
        while (iterator.hasPrevious()) {
            list.add(iterator.previous());
        }
        result.add(list);
    }
}

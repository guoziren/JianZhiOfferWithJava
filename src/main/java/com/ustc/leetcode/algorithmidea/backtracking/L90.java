package com.ustc.leetcode.algorithmidea.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 */
public class L90 {
    /**
     * 参考L78
     * {1,1,3,3}这种情况
     * 为什么要先排序？
     * 4 , 4, 4, 1, 4 这种情况，2组合时，4,1  ，到1时，1不应该与后面的4组合，排序后就不存在这个问题
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        LinkedList<Integer> stack = new LinkedList<>();
        Arrays.sort(nums); //
        for (int i = 0; i <= nums.length ; i++) {
            dfs(nums,1,result, visited, stack, i);
        }
        return result;
    }

    private void dfs(int[] nums, int height, List<List<Integer>> result, boolean[] visited, LinkedList<Integer> stack, int k) {
        if (k == 0) {
            result.add(new ArrayList<>());
            return;
        }
        if (height > k) {
            return;
        }
        List<Integer> currentIndexVisited = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            // 先判断当前层是否已访问过， 剪掉访问过的枝
            if(isInCurrentLevelVisited(i,currentIndexVisited,nums)){
                // 有重复元素的组合，在剪掉的同时，也要标记为访问过
                if (!currentIndexVisited.contains(i)) {
                    currentIndexVisited.add(i);
                }
                visited[i] = true; // 使得 序列每个数都是找组合都是从后面找
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                currentIndexVisited.add(i);
                stack.push(nums[i]);
                if (height == k) {
                    //
                    addOne(result, stack);
                }
                dfs(nums, height + 1, result, visited, stack, k);
                stack.pop();
            }
        }
        // 每一层遍历完，访问状态恢复为未访问，然后返回上一层
        currentIndexVisited.forEach(index -> visited[index] = false);
    }

    private void addOne(List<List<Integer>> result, LinkedList<Integer> stack) {
        List<Integer> list= new ArrayList<>();
        for (Integer integer : stack) {
            list.add(integer);
        }
        result.add(list);
    }

    private boolean isInCurrentLevelVisited(int j, List<Integer> currentLevelVisitedIndex, int[] nums) {
        //
        int curNum = nums[j];
        for (Integer levelVisitedIndex : currentLevelVisitedIndex) {
            if (nums[levelVisitedIndex] == curNum) {
                return true;
            }
        }
        return false;
    }
}

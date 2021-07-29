package com.ustc.leetcode.algorithmidea.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 */
public class L78 {
    /**
     * 参考L77
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i <= nums.length ; i++) {
            dfs(nums,1,result, visited, stack, i);
        }
        return result;
    }

    private void dfs(int[] nums, int height, List<List<Integer>> result, boolean[] visited, LinkedList<Integer> stack, int k) {
        if (k == 0) {
            result.add(new ArrayList<>());
        }
        if (height > k) {
            return;
        }
        List<Integer> currentIndexVisited = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            // 先判断当前层是否已访问过， 剪掉访问过的枝
            if(isInCurrentLevelVisited(i,currentIndexVisited,nums)){
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

package com.ustc.leetcode.algorithmidea.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        LinkedList<Integer> stack = new LinkedList<>();
        dfs(candidates, visited, target, stack, result);
        return result;
    }

    /**
     * 1.路径怎么存， 用栈存
     * 2.如何去重
     *  @param candidates
     * @param visited
     * @param target
     * @param result
     */
    public void dfs(int[] candidates, boolean[] visited, int target, LinkedList<Integer> stack, List<List<Integer>> result) {
        List<Integer> currentLevelVisited = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            // 去重(剪枝)
            if (isVisited(i, currentLevelVisited, candidates, visited)) {
                continue;
            }
            if (!visited[i]) {
                stack.push(candidates[i]);
                int newTarget = target - candidates[i];
                currentLevelVisited.add(i);
                visited[i] = true;
                if (newTarget > 0) {
                    dfs(candidates, visited,newTarget, stack, result);
                } else if (newTarget == 0) {
                    // 找到
                    add(stack, result);
                }
                stack.pop();
            }
        }
        // 当前层遍历结束， 恢复访问过的 为 未访问
        currentLevelVisited.forEach(index -> visited[index] = false);
    }

    private boolean isVisited(int i, List<Integer> currentLevelVisited, int[] candidates, boolean[] visited) {
        for (int i1 = 0; i1 < currentLevelVisited.size(); i1++) {
            if (candidates[currentLevelVisited.get(i1)] == candidates[i]) {
                visited[i] = true;
                currentLevelVisited.add(i);
                return true;
            }
        }
        return false;
    }

    private void add(LinkedList<Integer> stack, List<List<Integer>> result) {
        List<Integer> list = new ArrayList<>();
        for (Integer integer : stack) {
            list.add(integer);
        }
        result.add(list);
    }
}

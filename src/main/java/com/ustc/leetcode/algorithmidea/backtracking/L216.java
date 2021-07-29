package com.ustc.leetcode.algorithmidea.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 * https://leetcode-cn.com/problems/combination-sum-iii/
 */
public class L216 {
    /**
     * 深度优先遍历， 参考组合II 或 L77
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        LinkedList<Integer> stack = new LinkedList<>();
        dfs(n,1,result, visited, stack, k);
        return result;
    }

    private void dfs(int target, int height, List<List<Integer>> result, boolean[] visited, LinkedList<Integer> stack, int k) {
        if (height > k || target <= 0) {
            return;
        }
        List<Integer> currentIndexVisited = new ArrayList<>();
        int limit = target <= 9 ? target : 9;
        for (int i = 1; i <= limit; i++) {
            if (currentIndexVisited.contains(i)) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                currentIndexVisited.add(i);
                stack.push(i);
                int newTaret = target - i;
                if (newTaret == 0 && height == k) {
                    addOne(result, stack);
                }
                dfs(newTaret, height + 1, result, visited, stack, k);
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
}

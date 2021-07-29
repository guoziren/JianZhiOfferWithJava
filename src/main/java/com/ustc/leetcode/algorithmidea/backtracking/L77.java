package com.ustc.leetcode.algorithmidea.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 */
public class L77 {
    /**
     * 参考L47 , 基本一致
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        LinkedList<Integer> stack = new LinkedList<>();
        dfs(n,1,result, visited, stack, k);
        return result;
    }

    private void dfs(int n, int height, List<List<Integer>> result, boolean[] visited, LinkedList<Integer> stack, int k) {
        if (height > k) {
            return;
        }
        List<Integer> currentIndexVisited = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            // 先判断当前层是否已访问过， 剪掉访问过的枝
            if(currentIndexVisited.contains(i)){
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                currentIndexVisited.add(i);
                stack.push(i);
                if (height == k) {
                    //
                    addOne(result, stack);
                }
                dfs(n, height + 1, result, visited, stack, k);
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

package com.ustc.leetcode.algorithmidea.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class L47 {
    /**
     * 深度优先遍历
     * visited[i] 表示第i个元素已访问过，
     * currentLevelVisitedIndex表示当前层已经反问过的元素的下标， 有元素在当前层已访问过，则跳过， 用于过滤重复的。
     * dfs的目标是建立nums数组长度颗树，以每个不同的数为根
     * 遍历完一层后， currentLevelVisitedIndex 访问过恢复为未访问， 根恢复为未访问, 并弹出根
     * stach 用于记录访问的路径, 访问一个未被访问的节点时，压入栈，他的孩子都访问完后，弹出根
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        boolean[] visited = new boolean[len];
        LinkedList<Integer> stack = new LinkedList<>();
        dfs(nums, visited, 1, result, stack);
        return result;
    }

    private void dfs(int[] nums, boolean[] visited, int height, List<List<Integer>> result, LinkedList<Integer> stack) {
        if (height > nums.length) {
            return;
        }
        List<Integer> currentLevelVisitedIndex = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            // 先判断当前层是否已访问过， 剪掉访问过的枝
            if(isInCurrentLevelVisited(j,currentLevelVisitedIndex,nums)){
                continue;
            }
            if (!visited[j]) {
                visited[j] = true;
                currentLevelVisitedIndex.add(j);
                stack.push(nums[j]);
                if(height == nums.length) {
                    // 输出
                    addOne(result, stack);
                }

                dfs(nums, visited, height + 1, result, stack);
                // 弹出
                visited[j] = false;
                stack.pop();
            }
        }
        currentLevelVisitedIndex.forEach(index -> visited[index] = false);
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

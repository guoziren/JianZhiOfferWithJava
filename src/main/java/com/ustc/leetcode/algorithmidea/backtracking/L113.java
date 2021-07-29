package com.ustc.leetcode.algorithmidea.backtracking;

import com.ustc.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class L113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        dfs(root, result, stack, targetSum);
        return result;
    }

    private void dfs(TreeNode root, List<List<Integer>> result, LinkedList<Integer> stack, int targetSum) {
        if (root == null) {
            return;
        }

        int newTargetSum = targetSum - root.val;
        stack.push(root.val);
        if (newTargetSum == 0 && root.left == null && root.right == null) {
            addOne(result, stack);
        }
        dfs(root.left, result, stack, newTargetSum);
        dfs(root.right, result, stack, newTargetSum);
        stack.pop();
    }

    private void addOne(List<List<Integer>> result, LinkedList<Integer> stack) {
        List<Integer> list = new ArrayList<>(stack);
        Collections.reverse(list);
        result.add(list);
    }
}

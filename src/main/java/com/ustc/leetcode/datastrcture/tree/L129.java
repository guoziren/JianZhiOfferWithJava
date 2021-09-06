package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * 129. 求根节点到叶节点数字之和
 */
public class L129 {
    int sum = 0;
    public int sumNumbers(TreeNode root) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        dfs(root, linkedList);
        return sum;
    }

    private void dfs(TreeNode root, LinkedList<Integer> linkedList) {
        if (root == null) {
            return;
        }
        linkedList.push(root.val);
        dfs(root.left, linkedList);
        dfs(root.right, linkedList);
        if (root.left == null && root.right == null) {
            sum += calculateSum(linkedList);
        }
        linkedList.pop();
    }

    private int calculateSum(LinkedList<Integer> linkedlist) {
        Iterator<Integer> iterator = linkedlist.iterator();
        int exp = 0, temp = 0;
        while (iterator.hasNext()) {
            Integer previous = iterator.next();
            temp += Math.pow(10,exp) * previous;
            exp++;
        }
        return temp;
    }
}

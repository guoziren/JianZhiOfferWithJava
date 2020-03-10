package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层次遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/submissions/
 */
public class L102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null){
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        //记录层数的关键
        int curLevelCount = 1,nextLevelCount = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            curLevelCount--;
            if (node.left != null){
                queue.add(node.left);
                nextLevelCount++;
            }
            if (node.right != null){
                queue.add(node.right);
                nextLevelCount++;
            }
            if (curLevelCount == 0){
                lists.add(list);
                list = new ArrayList<>();
                curLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }

        }
        return lists;
    }

}

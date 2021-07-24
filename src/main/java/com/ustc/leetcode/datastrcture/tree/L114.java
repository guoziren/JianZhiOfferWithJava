package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/submissions/
 * 114. 二叉树展开为链表
 */
public class L114 {
    public void flatten(TreeNode root) {
        TreeNode gen = traverse(root);
    }

    private TreeNode traverse(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = traverse(root.left);
        TreeNode right = traverse(root.right);
        if (left != null) {
            root.left = null;
            root.right = left;
            TreeNode lastRight = findLastRight(left);
            lastRight.right = right;
        }
        return root;
    }

    private TreeNode findLastRight(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}

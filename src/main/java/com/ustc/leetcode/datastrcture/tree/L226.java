package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

/**
 * 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/description/
 */
public class L226 {
    //递归处理左子树和右子树
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

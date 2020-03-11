package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/description/
 * 538. 把二叉搜索树转换为累加树
 */
public class L538 {
    private int pre = 0;
    private boolean isFirst = true;
    public TreeNode convertBST(TreeNode root) {
            if (root == null){
                return null;
            }
            convertBST(root.right);
            if (!isFirst){
                root.val = root.val + pre;
            }
            pre = root.val;
            isFirst = false;
            convertBST(root.left);
            return root;
    }
}

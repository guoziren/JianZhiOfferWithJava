package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/description/
 */
public class L530 {
    private boolean isFirst = true;
    private int min = Integer.MAX_VALUE;
    private int pre = 0;
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return min;
    }

    private void traverse(TreeNode root) {
        if (root == null){
            return;
        }
        traverse(root.left);
        if (isFirst){
            pre = root.val;
        }else{
            min = Math.min(Math.abs(root.val - pre),min);
            pre = root.val;
        }
        isFirst = false;
        traverse(root.right);

    }
}

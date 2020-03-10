package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/description/
 * 404.计算给定二叉树的所有左叶子之和。
 */
public class L404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return 0;
        }
        //左孩子是叶子节点
        int leftSum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null){
            leftSum = root.left.val;
        }else{
            leftSum = sumOfLeftLeaves(root.left);
        }
        int rightSum = sumOfLeftLeaves(root.right);
        return leftSum + rightSum;
    }
}

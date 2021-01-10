package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

/**
 * 543. 二叉树的直径
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 */
public class L543 {

    private int max = 0;
    public int diameterOfBinaryTree2(TreeNode root) {
        height(root);
        return max;
    }
    public int height(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        //计算以root为根的直径
        int cur = left + right ;
        //最大直径
        max = Math.max(max,cur);
        return Math.max(left,right) + 1;
    }
}

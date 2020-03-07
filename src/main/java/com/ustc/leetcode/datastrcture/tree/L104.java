package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

/**
 * 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class L104 {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int ldepth = maxDepth(root.left);
        int rdepth = maxDepth(root.right);
        return Math.max(ldepth,rdepth) + 1;
    }
}

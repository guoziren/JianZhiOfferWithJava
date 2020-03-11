package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 */
public class L236 {
    /**
     * 官方解法：时间上击败23~99%，不稳定.
     */
    private  TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root,p,q);
        return result;
    }

    private boolean traverse(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return false;
        }
        int b0 = 0;
        if (root == p || root == q){
            b0 = 1;
        }
         int b1 = traverse(root.left,p,q) ? 1 : 0;
        int b2 = traverse(root.right,p,q) ? 1 : 0;
        if ((b0 + b1 + b2) >= 2){
            result = root;
        }

        return (b0 + b1 + b2) > 0 ? true : false;
    }
}

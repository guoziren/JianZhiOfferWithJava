package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

/**
 * 543. 二叉树的直径
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 */
public class L543 {
    private int diameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        Data data = maxDepth(root);
        if(data.depth == 0){
            return 0;
        }
        return diameter;
    }

    /**
     *
     * @param root 树根
     * @return 返回经过root的最大直径 和以root为根的树的最大深度
     */
    public Data maxDepth(TreeNode root) {
        if(root == null){

            return new Data(0,0);
        }
        Data l = maxDepth(root.left);
        Data r = maxDepth(root.right);
        int d = l.depth + r.depth;
        if(d > diameter){
            diameter = d;
        }
        return new Data(Math.max(l.depth,r.depth) + 1,d);
    }
    class Data{
        int depth;
        int diameter;
        Data(int depth,int diameter){
            this.depth =depth;
            this.diameter = diameter;
        }
    }
}

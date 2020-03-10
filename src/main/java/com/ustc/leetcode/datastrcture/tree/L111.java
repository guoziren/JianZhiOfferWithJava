package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

/**
 * 111. 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
 */
public class L111 {
    private int min = Integer.MAX_VALUE;
    public int getHight(TreeNode root) {
        if (root == null){
            return 0;
        }
        int h = 1;
        getHight(root,h );
        return min;
    }
    //返回当前结点的高度
    private int getHight(TreeNode root, int h) {
        if (root == null){
           return h;
        }
        int left = getHight(root.right,h + 1);
        int right = getHight(root.left,h + 1);
        int curH = Math.min(left,right) - 1;
        if (root.left == null && root.right == null){
            min = curH < min ? curH : min;
        }
        return curH;
    }
}

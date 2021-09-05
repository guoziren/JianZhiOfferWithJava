package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * 124. 二叉树中的最大路径和
 */
public class L124 {
    private int maxPathSum = Integer.MIN_VALUE;

    /**
     * 开始以为仅是简单的后续遍历，这里要区分以root为根的最大路径和 和 以root为根的单边路径和
     * 中等吧，算不上困难
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxPathSum;
    }

    public PathSum pathSum(TreeNode root) {
        if (root == null) {
            return new PathSum(0,0);
        }
        PathSum leftPathSum = pathSum(root.left);
        PathSum rightPathSum = pathSum(root.right);
        int rootPathSum = root.val;
        int rootSinglePathSum = root.val;
        int leftSinglePathSum = leftPathSum.singlePathSum;
        int rightSinglePathSum = rightPathSum.singlePathSum;
        // 以root为根的最大路径和是与 左孩子和右孩子的最大单边路径有关
        if (leftSinglePathSum > 0 && rightSinglePathSum > 0) {
            rootPathSum += leftSinglePathSum + rightSinglePathSum;
            rootSinglePathSum += leftSinglePathSum > rightSinglePathSum ? leftSinglePathSum : rightSinglePathSum;
        } else if (leftSinglePathSum > 0 && rightSinglePathSum <= 0) {
            rootPathSum += leftSinglePathSum;
            rootSinglePathSum += leftSinglePathSum;
        } else if (leftSinglePathSum <= 0 && rightSinglePathSum > 0) {
            rootPathSum += rightSinglePathSum;
            rootSinglePathSum += rightSinglePathSum;
        }
        if (rootPathSum > maxPathSum) {
            setMaxPathSum(rootPathSum);
        }
        return new PathSum(rootSinglePathSum, rootPathSum);
    }

    public void setMaxPathSum(int maxPathSum) {
        this.maxPathSum = maxPathSum;
    }

    private static class PathSum{
        int singlePathSum; // 单条路径最大路径和
        int pathSum; //

        public PathSum(int singlePathSum, int pathSum) {
            this.singlePathSum = singlePathSum;
            this.pathSum = pathSum;
        }
    }
}

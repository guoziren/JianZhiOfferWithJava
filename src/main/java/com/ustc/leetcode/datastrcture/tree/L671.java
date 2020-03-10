package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

import java.util.*;

/**
 * 671. 二叉树中第二小的节点
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 * 思路：根节点是最小值，层次遍历整棵树，找出第二小的
 * 时间复杂度O(N)，空间复杂度O(N)
 */
public class L671 {
    public int findSecondMinimumValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int result = root.val;
        boolean flag = false;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.val > result && !flag ){
                result = node.val;
                flag = true;
            }
            if (flag && node.val < result && node.val > root.val){
                result = node.val;
            }
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        return result == root.val ? -1 : result;
    }


}

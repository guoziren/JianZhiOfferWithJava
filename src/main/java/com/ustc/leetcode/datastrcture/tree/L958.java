package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
 * 958. 二叉树的完全性检验
 */
public class L958 {
    /**
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<ANode> list = new ArrayList<>();
        list.add(new ANode(root, 1));
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                list.add(new ANode(node.left, 2 * node.val));
            }
            if (node.right != null) {
                queue.offer(node.right);
                list.add(new ANode(node.right, 2 * node.val + 1));
            }
        }
        return list.get(list.size() - 1).code == list.size();
    }

    public static void main(String[] args) {

    }

    class ANode {
        TreeNode node;
        int code;

        public ANode(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }
}

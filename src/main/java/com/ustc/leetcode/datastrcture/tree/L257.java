package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class L257 {
    /**
     * 非递归
     * @param root
     * @return
     */
        public List<String> binaryTreePaths(TreeNode root) {
            LinkedList<String> paths = new LinkedList();
            if (root == null) {
                return paths;
            }

            LinkedList<TreeNode> node_stack = new LinkedList();
            LinkedList<String> path_stack = new LinkedList();
            node_stack.add(root);
            path_stack.add(Integer.toString(root.val));
            TreeNode node;
            String path;
            while (!node_stack.isEmpty()) {
                node = node_stack.pollLast();
                path = path_stack.pollLast();
                if ((node.left == null) && (node.right == null)) {
                    paths.add(path);
                }
                if (node.left != null) {
                    node_stack.add(node.left);
                    path_stack.add(path + "->" + Integer.toString(node.left.val));
                }
                if (node.right != null) {
                    node_stack.add(node.right);
                    path_stack.add(path + "->" + Integer.toString(node.right.val));
                }
            }
            return paths;
        }

}

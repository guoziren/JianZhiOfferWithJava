package com.ustc.leetcode.datastrcture.tree;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * 429. N 叉树的层序遍历
 */
public class L429 {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int currentLevel = 1;
        int currentNum = 1;
        while (!queue.isEmpty()) {
            Node parent = queue.poll();
            currentNum--;

            if (parent.children != null) {
                for (Node child : parent.children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
            }
        }
        return result;
    }
}

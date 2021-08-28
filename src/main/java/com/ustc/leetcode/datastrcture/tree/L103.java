package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

import java.util.*;

public class L103 {
    /**
     * 采用双端队列Deque
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isOdd = true;
        int curLevelNum = 1;
        int nextLevelNum = 0;
        while (!queue.isEmpty()) {
            Deque<Integer> deque = new LinkedList<>();
            for (int i = curLevelNum; i > 0; i--) {
                TreeNode node = queue.poll();
                if (isOdd) {
                    deque.offerLast(node.val);
                }else {
                    deque.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    nextLevelNum++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextLevelNum++;
                }
            }
            curLevelNum = nextLevelNum;
            nextLevelNum = 0;
            List<Integer> list = new ArrayList<>(deque);
            isOdd = !isOdd;
            result.add(list);
        }
        return result;
    }

}

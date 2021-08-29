package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */
public class L199 {
    /**
     * 层次遍历，找每层最右的节点，easy
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null ) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curLevelNum = 1;
        int nextLevelNum = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < curLevelNum; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    nextLevelNum++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextLevelNum++;
                }
                if (i == curLevelNum - 1) {
                    result.add(node.val);
                }
            }
            curLevelNum = nextLevelNum;
            nextLevelNum = 0;
        }
        return result;
    }
}

package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;
import com.ustc.zuoshen.day04.BinaryTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L662 {

    @Test
    public void test2() {
        int pre[] = {1, 3, 5, 6 , 2, 9};
        int in[] = {6,5,3,1,2,9};
        int res = widthOfBinaryTree(new BinaryTree().construct(pre, in, 6));
        System.out.println(res);
    }

    /**
     * 利用ANode结构，给每个树节点添加一个位置，像完全二叉树一样
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<ANode> queue = new LinkedList<>();
        int curLevelNum = 1, nextLevNum = 0;
        int maxWidth = curLevelNum;
        StringBuilder sb = new StringBuilder();
        queue.offer(new ANode(1, root));
        List<ANode> treeNodes = new ArrayList<>();
        int width = 1;
        while (!queue.isEmpty()) {
            for (int i = 0; i < curLevelNum; i++) {
                ANode p = queue.poll();
                if (p.node.left != null) {
                    ANode e = new ANode(p.position * 2, p.node.left);
                    queue.offer(e);
                    nextLevNum++;
                    treeNodes.add(e);
                }
                if (p.node.right != null) {
                    ANode e = new ANode(p.position * 2 + 1, p.node.right);
                    queue.offer(e);
                    treeNodes.add(e);
                    nextLevNum++;
                }
            }
            // 计算当前层的宽度
            int currentLevelWidth = getCurrentLevelWidth(treeNodes);
            if (currentLevelWidth > width) {
                width = currentLevelWidth;
            }
            treeNodes = new ArrayList<>();
            curLevelNum = nextLevNum;
            nextLevNum = 0;
        }
        return width;
    }

    private int getCurrentLevelWidth(List<ANode> treeNodes) {
        if (treeNodes.size() == 0) {
            return 0;
        }
        // 找到第一个不为0的节点
        int firstIndex = -1;
        for (int i = 0; i < treeNodes.size(); i++) {
            if (treeNodes.get(i) != null) {
                firstIndex = i;
                break;
            }
        }
        int l = treeNodes.get(firstIndex).position;
        // 找最后一个不为0的节点
        int lastIndex = -1;
        for (int i = treeNodes.size() - 1; i > firstIndex; i--) {
            if (treeNodes.get(i) != null) {
                lastIndex = i;
                break;
            }
        }
        if (lastIndex == -1) {
            return 1;
        }
        int r = treeNodes.get(lastIndex).position;
        return r - l + 1;
    }

    class ANode {
        int position;
        TreeNode node;

        public ANode(int position, TreeNode node) {
            this.position = position;
            this.node = node;
        }
    }
}

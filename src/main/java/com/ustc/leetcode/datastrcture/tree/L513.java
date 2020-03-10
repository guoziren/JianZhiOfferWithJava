package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L513 {
    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        //记录层数的关键
        int result = 0;
        int curLevelCount = 1, nextLevelCount = 0;
        boolean flag = false;//控制1层只对result赋值1次
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (nextLevelCount == 0 && !flag){
                result = node.val;
                flag = true;
            }
            curLevelCount--;
            if (node.left != null) {
                queue.add(node.left);
                nextLevelCount++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevelCount++;
            }
            if (curLevelCount == 0) {
                flag = true;
                curLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }

        }
        return result;
    }
}

package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. 二叉树的层平均值
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 */
public class L637 {
    public List<Double> averageOfLevels(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        List<Double> list = new ArrayList<>();
        //记录层数的关键
        int curLevelCount = 1,nextLevelCount = 0;
        int curLevelCount2 = 1;
        double sum = 0.0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            sum += node.val;

            curLevelCount--;
            if (node.left != null){
                queue.add(node.left);
                nextLevelCount++;
            }
            if (node.right != null){
                queue.add(node.right);
                nextLevelCount++;
            }
            if (curLevelCount == 0){
                list.add(sum / curLevelCount2);
                curLevelCount2 = nextLevelCount;
                sum = 0.0;
                curLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }

        }
        return list;
    }
}

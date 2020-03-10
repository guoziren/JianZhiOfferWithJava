package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class L337 {
    public int rob(TreeNode root) {
       if (root == null){
           return 0;
       }
       Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       int level = 1,curLevelNode = 1,nextLevelNode = 0;
       int oddSum = 0;
       int evenSum = 0;
       while (!queue.isEmpty()){
           TreeNode node = queue.poll();
           oddSum = level % 2 != 0 ? oddSum + node.val : oddSum;
           evenSum = level % 2 == 0 ? evenSum + node.val : evenSum;
           curLevelNode--;
           if (node.left != null){
               queue.add(node.left);
               nextLevelNode++;
           }
           if (node.right != null){
               queue.add(node.right);
               nextLevelNode++;
           }
           if (curLevelNode == 0){
               curLevelNode = nextLevelNode;
               nextLevelNode = 0;
               level++;
           }
       }
       return Math.max(oddSum,evenSum);
    }
}

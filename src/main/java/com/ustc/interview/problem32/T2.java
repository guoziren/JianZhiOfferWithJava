package com.ustc.interview.problem32;

import java.util.*;

/**
 * 面试题32 - II. 从上到下打印二叉树 II
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 */
public class T2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list =new ArrayList<>();
        if (root == null){
            return list;
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentLevelNodeNum = 1,nextLevelNodeNum = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            currentLevelNodeNum--;
            result.add(node.val);
            if (node.left != null){
                queue.offer(node.left);
                nextLevelNodeNum++;
            }
            if (node.right != null){
                queue.offer(node.right);
                nextLevelNodeNum++;
            }
            if (currentLevelNodeNum == 0){
                list.add(result);
                result = new ArrayList<>();
                currentLevelNodeNum = nextLevelNodeNum;
                nextLevelNodeNum = 0;

            }
        }
        return list;
    }
}

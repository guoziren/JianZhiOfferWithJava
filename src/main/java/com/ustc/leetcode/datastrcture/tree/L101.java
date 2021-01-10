package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/description/
 * 什么叫对称？
 * 关键点：每颗树的右子树和另一个树的左子树镜像对称
 */
public class L101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isChildSymmetric(root.left,root.right);
    }

    /**
     * 先序 与 对称的先序 比较
     * @param left
     * @param right
     * @return
     */
    private boolean isChildSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }
        if (left != null && right == null){
            return false;
        }
        if (left == null && right != null){
            return false;
        }
        if (left.val != right.val ){
            return false;
        }
        boolean s1 = isChildSymmetric(left.left,right.right);
        //若这一步已经不对称，直接返回
        if (!s1){
            return false;
        }
        boolean s2 = isChildSymmetric(left.right,right.left);
        return s1 && s2;
    }
    //非递归解法一，效率不如官方非递归解法
    public boolean isSymmetricUnRecur(TreeNode root){

        if (root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        //记录层数的关键
        int curLevelCount = 1,nextLevelCount = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node == null){
                list.add(null);
            }else{
                list.add(node.val);
            }
            curLevelCount--;
            if (node != null){
                queue.add(node.left);
                nextLevelCount++;
            }
            if (node != null){
                queue.add(node.right);
                nextLevelCount++;
            }
            if (curLevelCount == 0){
                boolean result = process(list);
                if (!result){
                    return false;
                }
                list = new ArrayList<>();
                curLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }
        return true;
    }
    private boolean  process(List<Integer> list) {
        int length = list.size();
        for (int i = 0,j = length - 1;i < length && j >= 0 && i <= j; i++,j--) {
            Integer i1 = list.get(i);
            Integer i2 = list.get(j);
            if ((i1 == null && i2 != null) || (i1 != null && i2 == null)){
                return false;
            }
            if (i1 != null && i2 != null && !i1.equals(i2)){
                return false;
            }
        }
        return true;
    }
    //非递归官方解法，空间复杂度O(N)
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) {continue;}
            if (t1 == null || t2 == null) {return false;}
            if(t1.val != t2.val) {return false;}
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}

package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;
import com.ustc.zuoshen.day04.BinaryTree;
import org.junit.Test;

import java.util.Arrays;

/**
 * 112. 路径总和
 * https://leetcode-cn.com/problems/path-sum/description/
 */
public class L112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null ){
            return false;
        }
        if (root.left == null && root.right == null && root.val != sum){
            return false;
        }
        int fatherPathSum = root.val;
        return traverse(root,sum,0);
    }

    private boolean traverse(TreeNode root, int sum, int fatherPathSum) {
        boolean flag1 = false;
        boolean flag2 = false;
        if (root.left != null){
          flag1 = traverse(root.left,sum,fatherPathSum + root.val);
        }
        //如果左子树找到了就返回
        if (flag1){
            return true;
        }
        if (root.right != null){
           flag2 = traverse(root.right,sum,fatherPathSum + root.val);
        }
        if (root.left == null && root.right == null && root.val + fatherPathSum == sum){
            return true;
        }
        return flag1 || flag2;
    }
    @Test
    public void test(){
        BinaryTree tree= new BinaryTree();
        int[] pre = {5,4,11,7,2,8,13,4,1};
        int[] in = {7,11,2,4,5,13,8,4,1};
        TreeNode root = tree.construct(pre,in,8);
        System.out.println( hasPathSum(root,22));

    }
}

package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;
import com.ustc.zuoshen.day04.BinaryTree;
import org.junit.Test;

import java.util.ArrayList;

public class L235Test {
    @Test
    public void test(){
        int[] pre = {5,3,2,1,4,6};
        int[] in = {1,2,3,4,5,6};
        TreeNode root = new  BinaryTree().construct(pre,in,6);
        L235 l = new L235();
        TreeNode res = l.lowestCommonAncestor(root,new TreeNode(1),new TreeNode(4));
        System.out.println(res.val);
    }

}

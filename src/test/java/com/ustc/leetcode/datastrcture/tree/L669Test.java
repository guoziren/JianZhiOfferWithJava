package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;
import com.ustc.zuoshen.day04.BinaryTree;
import org.junit.Test;

public class L669Test {
    @Test
    public void test(){
        L669 l = new L669();
        TreeNode root = new BinaryTree().construct(new int[]{1,0,2},new int[]{0,1,2},3);
        l.trimBST(root,1,2);
    }
    @Test
    public void test2(){
        L669 l = new L669();
        TreeNode root = new BinaryTree().construct(new int[]{3,0,2,1,4},new int[]{0,1,2,3,4},5);
        root = l.trimBST(root,1,3);
        System.out.println("");
    }
}

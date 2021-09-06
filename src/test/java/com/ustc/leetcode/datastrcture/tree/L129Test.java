package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L129Test {

    @Test
    void sumNumbers() {
        L129 l129 = new L129();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        int i = l129.sumNumbers(treeNode1);
        System.out.println(i);
    }
}
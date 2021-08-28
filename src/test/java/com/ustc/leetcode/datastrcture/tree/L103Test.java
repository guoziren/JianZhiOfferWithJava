package com.ustc.leetcode.datastrcture.tree;


import com.ustc.common.TreeNode;
import org.junit.Test;

import java.util.List;

public class L103Test {
    @Test
    public void testZigzagLevelOrder() {
        TreeNode tree = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        tree.left = n2;
        tree.right = n3;
        n2.left = n4;
        n2.right = n5;
        L103 l103 = new L103();
        List<List<Integer>> lists =
                l103.zigzagLevelOrder(tree);
        System.out.println(lists);
    }
}
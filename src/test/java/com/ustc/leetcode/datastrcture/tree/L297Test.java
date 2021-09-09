package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L297Test {

    @Test
    void serialize() {
    }

    @Test
    void deserialize() {
        L297 l297 = new L297();
        TreeNode root = l297.deserialize("[1,2,3]");
        assertEquals(1,root.val);
        assertEquals(2,root.left.val);

//        root = l297.deserialize("[1,2]");
//        assertEquals(1,root.val);
//        assertEquals(2,root.left.val);
//
//        root = l297.deserialize("[1,null,3]");
//        assertEquals(1,root.val);
//        assertEquals(3,root.right.val);
//
        root = l297.deserialize("[1,2,3,4,null,null,7,8]");
        assertEquals(1,root.val);
        assertEquals(3,root.right.val);

        String serialize = l297.serialize(root);
        System.out.println(serialize);
//        assertEquals("[1,2,3,4,null,null,7]", root);
    }
}
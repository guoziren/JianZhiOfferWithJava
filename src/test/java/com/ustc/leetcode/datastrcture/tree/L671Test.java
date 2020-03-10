package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;
import com.ustc.zuoshen.day04.BinaryTree;
import org.junit.Test;

import java.util.*;

public class L671Test {
    @Test
    public void test(){
        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.construct(new int[]{5,8,5},new int[]{8,5,5},3);
        L671 l = new L671();
        int res = l.findSecondMinimumValue(root);
        System.out.println(res);
    }
    @Test
    public void test2(){
        TreeMap map = new TreeMap();
        map.put(1,2);
        map.put(3,2);
        map.put(2,2);
        map.put(5,2);
        for (Object o : map.keySet()) {
            System.out.println(o);
        }



    }
    @Test
    public void test3(){
        PriorityQueue queue = new PriorityQueue();
        queue.add(1);
        queue.add(5);
        queue.add(3);
        queue.add(6);
        System.out.println(queue.peek());
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}

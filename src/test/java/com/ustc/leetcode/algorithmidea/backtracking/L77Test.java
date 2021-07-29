package com.ustc.leetcode.algorithmidea.backtracking;

import org.junit.Test;

import java.util.List;

public class L77Test {

    @Test
    public void combine() {
        L77 l77 = new L77();
        List<List<Integer>> lists = l77.combine(4,2);
        System.out.println(lists);
        lists = l77.combine(3,2);
        System.out.println(lists);
        lists = l77.combine(1,1);
        System.out.println(lists);
    }
}
package com.ustc.leetcode.algorithmidea.backtracking;

import org.junit.Test;

import java.util.List;

public class L78Test {

    @Test
    public void subsets() {
        L78 l78 = new L78();
        List<List<Integer>> lists = l78.subsets(new int[]{1,2,3});
        System.out.println(lists);

        lists = l78.subsets(new int[]{1});
        System.out.println(lists);
    }
}
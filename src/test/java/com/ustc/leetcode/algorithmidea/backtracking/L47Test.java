package com.ustc.leetcode.algorithmidea.backtracking;

import org.junit.Test;

import java.util.List;

public class L47Test {

    @Test
    public void permuteUnique() {
        L47 l47 = new L47();
        List<List<Integer>> lists = l47.permuteUnique(new int[]{1, 2, 3});
        System.out.println(lists);
        lists = l47.permuteUnique(new int[]{1,1,2});
        System.out.println(lists);
        lists = l47.permuteUnique(new int[]{1,1,3,3});
        System.out.println(lists);
        lists = l47.permuteUnique(new int[]{1,1});
        System.out.println(lists);
        lists = l47.permuteUnique(new int[]{1});
        System.out.println(lists);
    }
}
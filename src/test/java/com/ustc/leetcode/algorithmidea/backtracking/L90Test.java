package com.ustc.leetcode.algorithmidea.backtracking;

import org.junit.Test;

import java.util.List;

public class L90Test {

    @Test
    public void subsetsWithDup() {
        L90 l90 = new L90();
        List<List<Integer>> lists = l90.subsetsWithDup(new int[]{4,4,4,1,4});
        System.out.println(lists);
    }
}
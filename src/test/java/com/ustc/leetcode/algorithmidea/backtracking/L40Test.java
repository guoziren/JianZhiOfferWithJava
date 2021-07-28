package com.ustc.leetcode.algorithmidea.backtracking;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class L40Test {

    @Test
    public void combinationSum2() {
        L40 l40 = new L40();
        List<List<Integer>> lists = l40.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(lists);
        List<List<Integer>> lists2 = l40.combinationSum2(new int[]{2,5,2,1,2}, 5);
        System.out.println(lists2);
        List<List<Integer>> lists3 = l40.combinationSum2(new int[]{1,1,1,3,3,5}, 8);
        System.out.println(lists3);
    }
}
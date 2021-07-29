package com.ustc.leetcode.algorithmidea.backtracking;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class L216Test {

    @Test
    public void combinationSum3() {
        L216 l216 = new L216();
        List<List<Integer>> lists = l216.combinationSum3(3, 7);
        System.out.println(lists);

        lists = l216.combinationSum3(3, 9);
        System.out.println(lists);

        lists = l216.combinationSum3(1, 7);
        System.out.println(lists);
    }
}
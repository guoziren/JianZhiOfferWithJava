package com.ustc.leetcode.algorithmidea.backtracking;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class L39Test {

    @Test
    public void combinationSum() {
        L39 l39 = new L39();
        List<List<Integer>> lists = l39.combinationSum(new int[]{2, 3, 6, 7}, 7);
        List<List<Integer>> lists2 = l39.combinationSum(new int[]{3, 2, 6, 7}, 7);
        System.out.println();
    }
}
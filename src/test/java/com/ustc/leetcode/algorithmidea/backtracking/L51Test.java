package com.ustc.leetcode.algorithmidea.backtracking;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class L51Test {

    @Test
    public void solveNQueens() {
        L51 l51 = new L51();
        List<List<String>> lists = l51.solveNQueens(4);
        System.out.println(lists);
        lists = l51.solveNQueens(1);
        System.out.println(lists);
    }
}
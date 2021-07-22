package com.ustc.leetcode.basic.other;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class L46Test {

    @Test
    public void permute() {
        L46 l46 = new L46();
        List<List<Integer>> permute = l46.permute(new int[]{1, 2, 3});
        List<List<Integer>> permute2 = l46.permute(new int[]{0,1});
        List<List<Integer>> permute3 = l46.permute(new int[]{1});
        System.out.println(permute);
    }
}
package com.ustc.leetcode.algorithmidea.backtracking;

import org.junit.Test;

import java.util.List;

public class L491Test {

    @Test
    public void findSubsequences() {
        L491 l491 = new L491();
        List<List<Integer>> subsequences = l491.findSubsequences(new int[]{4, 6, 7, 7});
        System.out.println(subsequences);

        subsequences = l491.findSubsequences(new int[]{4, 6});
        System.out.println(subsequences);

        subsequences = l491.findSubsequences(new int[]{4, 4,3,2,1});
        System.out.println(subsequences);

        subsequences = l491.findSubsequences(new int[]{1,2,3,4,5,6,7,8,9,10,1,1,1,1,1});
        System.out.println(subsequences);
    }
}
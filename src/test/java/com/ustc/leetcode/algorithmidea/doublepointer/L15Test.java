package com.ustc.leetcode.algorithmidea.doublepointer;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class L15Test {

    @Test
    public void threeSum() {
        L15 l15 = new L15();
        List<List<Integer>> result = l15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertTrue(result.size() == 2);
        result = l15.threeSum(new int[]{1,2,-2,-1});
        assertTrue(result.size() == 0);

    }
}
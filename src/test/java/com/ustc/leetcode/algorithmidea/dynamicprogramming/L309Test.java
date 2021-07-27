package com.ustc.leetcode.algorithmidea.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class L309Test {

    @Test
    public void maxProfit() {
        L309 l309 = new L309();
        int result = l309.maxProfit(new int[]{1, 2, 3, 0, 2});
        Assert.assertEquals(3, result);
        Assert.assertEquals(4, l309.maxProfit(new int[]{1, 2, 5}));
        Assert.assertEquals(1, l309.maxProfit(new int[]{1, 2}));
    }
}
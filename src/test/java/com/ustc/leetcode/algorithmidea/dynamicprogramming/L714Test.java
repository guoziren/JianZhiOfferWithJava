package com.ustc.leetcode.algorithmidea.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class L714Test {

    @Test
    public void maxProfit() {
        L714 l714 = new L714();
        Assert.assertEquals(8, l714.maxProfit(new int[]{1, 3, 2, 8, 4, 9},2));
        Assert.assertEquals(6, l714.maxProfit(new int[]{1,3,7,5,10,3},3));
    }
}
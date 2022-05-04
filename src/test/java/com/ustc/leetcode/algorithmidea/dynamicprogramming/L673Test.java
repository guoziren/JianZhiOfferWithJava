package com.ustc.leetcode.algorithmidea.dynamicprogramming;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class L673Test {

    @Test
    public void findNumberOfLIS() {
        L673 l673 = new L673();
        int numberOfLIS = l673.findNumberOfLIS(new int[]{1,3,5,4,7});
        Assert.assertEquals(2, numberOfLIS);

        numberOfLIS = l673.findNumberOfLIS(new int[]{2,2,2,2,2});
        Assert.assertEquals(5, numberOfLIS);

        numberOfLIS = l673.findNumberOfLIS(new int[]{10,9,2,5,3,7,101,18});
        Assert.assertEquals(4, numberOfLIS);

        // 关键用例
        numberOfLIS = l673.findNumberOfLIS(new int[]{1,2,3,1,2,3,1,2,3});
        Assert.assertEquals(10, numberOfLIS);
    }
}

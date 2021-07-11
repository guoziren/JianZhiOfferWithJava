package com.ustc.leetcode.algorithmidea.doublepointer;

import org.junit.Test;

import static org.junit.Assert.*;

public class L11Test {

    @Test
    public void maxArea() {
        L11 l11 = new L11();
        assertEquals(1,l11.maxArea(new int[]{1,1}));
        assertEquals(49,l11.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        assertEquals(16,l11.maxArea(new int[]{4,3,2,1,4}));
        assertEquals(2,l11.maxArea(new int[]{1,2,1}));
    }
}
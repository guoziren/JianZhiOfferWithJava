package com.ustc.leetcode.basic.other;

import org.junit.Test;

import static org.junit.Assert.*;

public class L42Test {

    @Test
    public void trap() {
        L42 l42 = new L42();
        assertEquals(6, l42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        assertEquals(9, l42.trap(new int[]{4,2,0,3,2,5}));
        assertEquals(0, l42.trap(new int[]{4}));
        assertEquals(0, l42.trap(new int[]{0,0,0,0,5}));
        assertEquals(0, l42.trap(new int[]{}));
    }
}
package com.ustc.leetcode.algorithmidea.binarysearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class L96Test {

    @Test
    public void numTrees() {
        L96 l96 = new L96();
        assertEquals(1,l96.numTrees(1));
        assertEquals(2,l96.numTrees(2));
        assertEquals(5,l96.numTrees(3));
    }
}
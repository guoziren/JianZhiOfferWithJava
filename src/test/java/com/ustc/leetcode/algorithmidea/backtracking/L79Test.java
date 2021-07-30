package com.ustc.leetcode.algorithmidea.backtracking;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class L79Test {

    @Test
    public void exist() {
        L79 l79 = new L79();
        Assert.assertTrue(l79.exist(new char[][]{
                {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
        },"ABCCED"));

        Assert.assertTrue(l79.exist(new char[][]{
                {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
        },"SEE"));

        Assert.assertFalse(l79.exist(new char[][]{
                {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
        },"ABCDEF"));
    }
}
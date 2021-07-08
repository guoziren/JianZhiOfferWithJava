package com.ustc.leetcode.datastrcture.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class L647Test {

    @Test
    public void countSubstrings() {
        L647 l647 = new L647();
        assertEquals(3,l647.countSubstrings("abc"));
        assertEquals(1,l647.countSubstrings("a"));
        assertEquals(6,l647.countSubstrings("aaa"));
    }
}
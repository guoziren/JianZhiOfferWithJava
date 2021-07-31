package com.ustc.leetcode.basic.other;

import org.junit.Test;

import static org.junit.Assert.*;

public class L415Test {

    @Test
    public void addStrings() {
        L415 l415 = new L415();
        assertEquals("246",l415.addStrings("123","123"));
        assertEquals("1000",l415.addStrings("1","999"));
        assertEquals("1",l415.addStrings("1",""));
        assertEquals("22",l415.addStrings("","22"));
        assertEquals("1000",l415.addStrings("125","875"));
    }
}
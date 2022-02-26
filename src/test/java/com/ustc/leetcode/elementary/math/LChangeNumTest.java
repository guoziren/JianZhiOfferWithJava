package com.ustc.leetcode.elementary.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LChangeNumTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void romanToInt() {
        LChangeNum lChangeNum = new LChangeNum();
        assertEquals(3, lChangeNum.romanToInt("III"));
        assertEquals(4, lChangeNum.romanToInt("IV"));
        assertEquals(9, lChangeNum.romanToInt("IX"));
        assertEquals(58, lChangeNum.romanToInt("LVIII"));
        assertEquals(1994, lChangeNum.romanToInt("MCMXCIV"));
    }
}

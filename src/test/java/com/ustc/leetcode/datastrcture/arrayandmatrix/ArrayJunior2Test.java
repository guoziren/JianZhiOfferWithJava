package com.ustc.leetcode.datastrcture.arrayandmatrix;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayJunior2Test {

    @Test
    void plusOne() {
        ArrayJunior2 junior2 = new ArrayJunior2();
        int[] result = junior2.plusOne(new int[]{0});
        assertEquals(1, result[0]);

        result = junior2.plusOne(new int[]{9,9});
        assertEquals(1, result[0]);

        result = junior2.plusOne(new int[]{1,2, 3});
        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
        assertEquals(4, result[2]);
    }
}

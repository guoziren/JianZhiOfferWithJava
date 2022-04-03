package com.ustc.leetcode.datastrcture.arrayandmatrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayJunior1Test {

    @Test
    void intersect() {
        ArrayJunior1 arrayJunior1 = new ArrayJunior1();
        int[] intersect = arrayJunior1.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        Assertions.assertEquals(2, intersect.length);
    }
}

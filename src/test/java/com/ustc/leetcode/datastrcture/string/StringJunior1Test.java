package com.ustc.leetcode.datastrcture.string;

import static org.junit.jupiter.api.Assertions.*;

import com.ustc.leetcode.datastrcture.string.StringJunior1;
import org.junit.jupiter.api.Test;

class StringJunior1Test {
    @Test
    public void test() {
        StringJunior1 stringJunior1 = new StringJunior1();
        assertEquals(-43, stringJunior1.myAtoi("  -43"));
        assertEquals(Integer.MAX_VALUE, stringJunior1.myAtoi("434444444444444444444"));
        assertEquals(Integer.MIN_VALUE, stringJunior1.myAtoi("-434444444444444444444"));
        assertEquals(0, stringJunior1.myAtoi("    -asba"));
        assertEquals(0, stringJunior1.myAtoi(""));
        assertEquals(0, stringJunior1.myAtoi(" "));
        assertEquals(0, stringJunior1.myAtoi("  -asdfasdfasdf"));
        assertEquals(4321, stringJunior1.myAtoi("  4321 asdfasdf"));
        assertEquals(2147483647, stringJunior1.myAtoi("2147483648"));
        assertEquals(-2147483648, stringJunior1.myAtoi("-2147483648"));
    }
}

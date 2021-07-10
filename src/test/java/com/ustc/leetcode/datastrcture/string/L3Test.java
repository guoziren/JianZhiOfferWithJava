package com.ustc.leetcode.datastrcture.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class L3Test {

    @Test
    public void lengthOfLongestSubstring() {
        L3 l3 = new L3();
        assertEquals(0,l3.lengthOfLongestSubstring(""));
        assertEquals(1,l3.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3,l3.lengthOfLongestSubstring("abc"));
        assertEquals(3,l3.lengthOfLongestSubstring("abcbc"));
        assertEquals(4,l3.lengthOfLongestSubstring("abcbcda"));
        assertEquals(3,l3.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(3,l3.lengthOfLongestSubstring("pwwkew"));
    }
}
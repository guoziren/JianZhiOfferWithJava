package com.ustc.leetcode.basic.other;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class L17Test {

    @Test
    public void letterCombinations() {
        L17 l17 = new L17();
        List<String> list = l17.letterCombinations("");
        list = l17.letterCombinations("2");
        list = l17.letterCombinations("23");
        list = l17.letterCombinations("234");
    }
}
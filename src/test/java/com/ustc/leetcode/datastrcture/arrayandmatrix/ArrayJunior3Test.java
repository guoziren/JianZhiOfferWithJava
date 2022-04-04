package com.ustc.leetcode.datastrcture.arrayandmatrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayJunior3Test {

    @Test
    void isValidSudoku() {

        char[][] array = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        ArrayJunior3 arrayJunior3 = new ArrayJunior3();
        Assertions.assertTrue(arrayJunior3.isValidSudoku(array));
    }
}

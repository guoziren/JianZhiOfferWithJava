package com.ustc.leetcode.datastrcture.arrayandmatrix;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class L54Test {
    @Test
    public void test() {
        L54 l54 = new L54();
        int[][] matrix = new int[][]{{1}};
        List<Integer> integers = l54.spiralOrder(matrix);
        Assertions.assertThat(integers).contains(1);
        matrix = new int[][]{{1,2},{3,4}};
        integers = l54.spiralOrder(matrix);
        Assertions.assertThat(integers).hasSize(4);

        matrix = new int[][]{{1,2,3},{4,5,6}};
        integers = l54.spiralOrder(matrix);
        Assertions.assertThat(integers).hasSize(6);
        matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        integers = l54.spiralOrder(matrix);
        Assertions.assertThat(integers).hasSize(9);

        matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        integers = l54.spiralOrder(matrix);
        Assertions.assertThat(integers).hasSize(12);


    }
}

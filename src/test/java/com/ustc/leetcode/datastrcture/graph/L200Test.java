package com.ustc.leetcode.datastrcture.graph;

import static org.junit.Assert.*;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class L200Test {

    @Test
    public void numIslands() {
        L200 l200 = new L200();
        int result = l200.numIslands(new char[][]{});
        Assertions.assertThat(result).isEqualTo(0);
        result = l200.numIslands(null);
        Assertions.assertThat(result).isEqualTo(0);
        char[][] chars = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        result = l200.numIslands(chars);
        Assertions.assertThat(result).isEqualTo(1);

        chars = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        result = l200.numIslands(chars);
        Assertions.assertThat(result).isEqualTo(3);
        // 左边 的未考虑到
        chars = new char[][]{
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        };
        result = l200.numIslands(chars);
        Assertions.assertThat(result).isEqualTo(1);

        // 左边 的未考虑到
        chars = new char[][]{
                {'1','0','1','1','1'},
                {'1','0','1','0','1'},
                {'1','1','1','0','1'}
        };
        result = l200.numIslands(chars);
        Assertions.assertThat(result).isEqualTo(1);
    }
}
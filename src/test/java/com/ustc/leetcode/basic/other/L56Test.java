package com.ustc.leetcode.basic.other;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class L56Test {
    @Test
    public void test(){
        L56 l56 = new L56();
        int[][] case1 = new int[][]{{1,3},{2,6},{9,10},{15,18}};
        int[][] merge = l56.merge(case1);
        Assert.assertEquals(3,merge.length);

        case1 = new int[][]{{15,18},{1,3},{2,6},{9,10}};
        merge = l56.merge(case1);
        Assert.assertEquals(3,merge.length);

        case1 = new int[][]{{15,18},{1,3},{4,6},{9,10}};
        merge = l56.merge(case1);
        Assert.assertEquals(4,merge.length);
    }
}

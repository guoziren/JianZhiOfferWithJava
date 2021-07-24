package com.ustc.leetcode.algorithmidea.doublepointer;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class L75Test {

    @Test
    public void sortColors() {
        L75 l75 = new L75();
        int[] nums = {1, 1, 2, 1, 0, 2, 1};
        int[] nums2 = {2,0,2,1,1,0};
        l75.sortColors(nums);
        l75.sortColors(nums2);
        System.out.println(Arrays.asList(nums).toString());
    }
}
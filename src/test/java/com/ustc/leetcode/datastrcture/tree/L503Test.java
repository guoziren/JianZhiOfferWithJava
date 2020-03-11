package com.ustc.leetcode.datastrcture.tree;

import com.ustc.leetcode.datastrcture.stack_queue.L503;
import org.junit.Test;

import java.util.Arrays;

public class L503Test {
    @Test
    public void test(){
      L503 l = new L503();
      int[] nums = {1,2,1};
      int[] arr = l.nextGreaterElements(nums);
        System.out.println(Arrays.toString(arr));
    }

}

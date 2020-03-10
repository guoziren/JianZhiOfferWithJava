package com.ustc.leetcode.datastrcture.tree;

import com.ustc.leetcode.datastrcture.stack_queue.L20;
import org.junit.Test;

public class L20Test {
    @Test
    public void test(){
        L20 l = new L20();
        System.out.println(l.isValid("[[]"));
        System.out.println(l.isValid("[]()"));
        System.out.println(l.isValid("[[)))"));
        System.out.println(l.isValid("[[{}]]{}"));
        System.out.println(l.isValid("[[[[["));
    }

}

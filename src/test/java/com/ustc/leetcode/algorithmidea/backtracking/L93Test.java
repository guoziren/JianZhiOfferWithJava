package com.ustc.leetcode.algorithmidea.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class L93Test {

    @Test
    void restoreIpAddresses() {
        L93 l93 = new L93();
//        List<String> strings = l93.restoreIpAddresses("25525511135");
//        System.out.println(strings);
        List<String> strings;
        strings = l93.restoreIpAddresses("0000");
        System.out.println(strings);

        strings = l93.restoreIpAddresses("1111");
        System.out.println(strings);

        strings = l93.restoreIpAddresses("010010");
        System.out.println(strings);

        strings = l93.restoreIpAddresses("101023");
        System.out.println(strings);
    }
}
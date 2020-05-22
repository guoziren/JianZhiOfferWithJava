package com.ustc.interview.problem46;

import org.junit.Test;

public class Main {

    public int translateNum(int num) {
        char[] s = String.valueOf(num).toCharArray();
//        return foo(s,0);

        return getTranslationCount(s, 0);
    }

    //递归
    private int foo(char[] s, int i) {

        if (i == s.length - 1) {
            return 1;
        }
        int r = (s[i] - '0') * 10 + s[i + 1] - '0';
        if (i == s.length - 2) {
            if (r >= 10 && r <= 25) {
                return 2;
            } else {
                return 1;
            }
        }

        if (r >= 10 && r <= 25) {
            return foo(s, i + 1) + foo(s, i + 2);
        } else {
            return foo(s, i + 1);
        }

    }

    //非递归
    //
    private int getTranslationCount(char[] s, int i) {
        int length = s.length;
        int count = 0;
        int[] counts = new int[length];
        counts[length - 1] = 1;
        int k = length - 2;
        if (k >= 0) {
            int r = (s[k] - '0') * 10 + s[k + 1] - '0';
            if (r >= 10 && r <= 25) {
                counts[k] = 2;
            } else {
                counts[k] = 1;
            }
        }
        for (int j = length - 3; j >= 0; j--) {

            int r = (s[j] - '0') * 10 + s[j + 1] - '0';
            if (r >= 10 && r <= 25) {
                counts[j] = counts[j + 1] + counts[j + 2];
            } else {
                counts[j] = counts[j + 1];
            }
        }
        return counts[0];
    }

    @Test
    public void test() {

        System.out.println(translateNum(Integer.MAX_VALUE));
    }
}

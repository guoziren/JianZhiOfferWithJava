package com.ustc.leetcode.datastrcture.tree;
import org.junit.Test;

public class CommonTest {
    @Test
    public void test(){
        double a = 0.01231412345556d;
        float b = 0.125f;
        float c = 8.125f;
        System.out.println(a);
        System.out.println(Float.toHexString(b));
        System.out.println(Float.toHexString(c));

        System.out.println(Float.floatToIntBits(b));
        int r = Float.floatToIntBits(b);
        System.out.println( Integer.toHexString(r));
        System.out.println( Integer.toBinaryString(r)  + ":" + Integer.toBinaryString(r).length());
        System.out.println( Integer.toBinaryString(10)  + ":" + Integer.toBinaryString(10).length());
        System.out.println((int)b);
        short aaa = 2;
        int bbb = aaa;
        long ccc = bbb;
        float ddd = ccc;
        float eee = -5.6f;
        System.out.println(aaa);
        System.out.println(bbb);
        System.out.println(ccc);
        System.out.println(ddd);
        System.out.println((int)eee);

    }

}

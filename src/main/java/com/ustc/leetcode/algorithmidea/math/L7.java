package com.ustc.leetcode.algorithmidea.math;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 */
public class L7 {
    public int reverse(int x) {
        boolean isPositive = x >= 0 ? true : false;
        x = Math.abs(x);
        int res = 0;
        while (x > 0){
            int pop = x % 10;
            x = x / 10;

            if(res > Integer.MAX_VALUE / 10 || (res  == Integer.MAX_VALUE / 10 && pop > 7) ) {
                return 0;
            }
            res = res * 10 + pop;
        }
        if (!isPositive){
            res = res * -1;
        }
        return res;

    }
}

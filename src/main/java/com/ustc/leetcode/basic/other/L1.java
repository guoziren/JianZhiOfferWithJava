package com.ustc.leetcode.basic.other;

import org.junit.Test;

import java.util.Arrays;

public class L1 {
    // you need to treat n as an unsigned value

    /**
     * 位1的个数
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
//        String binaryString = Integer.toBinaryString(n);
            int count = 0;

        for (int i = 0; i < 32; i++) {
            if((n & 1) == 1){
                count++;

            }
            n = n >> 1;
        }
         return count;
    }


    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] res = Arrays.copyOf(digits,len);
        int jinwei = 1;
        for (int i = len - 1; i >= 0 ; i--) {

            if(res[i] + jinwei > 9){
                res[i] = 0;
            }else{
                jinwei = 0;
                res[i] = res[i] + 1;
            }
        }
        return res;
    }

}

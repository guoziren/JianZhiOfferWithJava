package com.ustc.leetcode.basic.other;

public class L470 {
    /**
     * rand7() 随机生成1到7  1 2 3 4 5 6 7  0 1 1 2 2 3 3
     * 随机是要做到等概率, 为什么rand7 * 2不行，为什么要×7？
     * @return
     */
    public int rand10() {
        int result =  (rand7() - 1) * 7 + rand7();
        while (result > 40) {
            result = (rand7() - 1) * 7 + rand7();
        }
        return result % 10 + 1;
    }

    public int rand7() {
        return (int) (Math.random() * 7) + 1;
    }

}

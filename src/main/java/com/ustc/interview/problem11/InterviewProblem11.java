package com.ustc.interview.problem11;

import org.junit.Test;

public class InterviewProblem11 {
    @Test
    public void test() {
        int[] arr = new int[]{3, 4, 5, 1, 2};
        int res = minNumberInRotateArray(arr);
        System.out.println(res);
    }

    public int minNumberInRotateArray(int[] array) {

        int len = array.length;
        if (len == 0) {
            return 0;
        }

        int p = 0, q = len - 1;
        int mid = 0;
        if (array[p] < array[q]) {
            return array[p];
        }
        //二分
        while (p <= q) {
            mid = p + (q - p) / 2;
            if (array[p] == array[q] && array[mid] == array[p]) {
                //可能在两边，只能顺序
                return findMin(array, p, q);
            }

            if (array[mid] >= array[p]) {
                p = mid;
            } else {
                q = mid;
            }
            if (p + 1 == q) {
                return array[q];
            }
        }

        return -1;
    }

    public int findMin(int[] array, int p, int q) {
        int min = Integer.MAX_VALUE;
        for (int i = p; i <= q; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

}

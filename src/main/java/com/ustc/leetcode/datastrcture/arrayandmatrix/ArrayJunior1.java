package com.ustc.leetcode.datastrcture.arrayandmatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayJunior1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int len1 = nums1.length, len2 = nums2.length;
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}

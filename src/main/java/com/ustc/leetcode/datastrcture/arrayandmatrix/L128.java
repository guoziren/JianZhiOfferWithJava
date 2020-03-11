package com.ustc.leetcode.datastrcture.arrayandmatrix;

import java.util.HashSet;

/**
 * 128. 最长连续序列
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class L128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestLength = 0;
        for (int num : nums) {
            int curNum = num;
            int curLen = 1;
            if (!set.contains(num - 1)){
                while (set.contains(curNum+1)){
                    curNum++;
                    curLen++;
                }
                longestLength = Math.max(longestLength,curLen);
            }
        }
        return longestLength;
    }
}

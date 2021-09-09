package com.ustc.leetcode.datastrcture.string;

import java.util.Arrays;

public class LJZO_014 {
    /**
     * 变为词就是字母相同，包括字母个数相同，但字母排列不同
     * 问题转为s2的长度和s1相同的子串 是否与s1互为变位词，通过比较字母个数是否 相等来判断
     * @param s1
     * @param s2
     * @return
     */

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] cnt1 = new int[26]; // 基于数组的哈希, 记录字母的个数
        int[] cnt2 = new int[26]; // 基于数组的哈希, 记录字母的个数
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cnt1,cnt2)) {
            return true;
        }
        int cha = s2.length() - s1.length();
        for (int i = 0; i < cha; i++) {
            cnt2[s2.charAt(i) - 'a']--;
            cnt2[s2.charAt(n + i) - 'a']++;
            if (Arrays.equals(cnt1,cnt2)) {
                return true;
            }
        }
        return false;
    }
}

package com.ustc.leetcode.datastrcture.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LJZO_015 {
    /**
     * 变为词就是字母相同，包括字母个数相同，但字母排列不同
     * @param p
     * @param s
     * @return
     */

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) {
            return result;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        int n = p.length();
        for (int i = 0; i < n; i++) {
            cnt1[p.charAt(i) - 'a']++;
            cnt2[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cnt1,cnt2)) {
            result.add(0);
        }
        int cha = s.length() - p.length();
        for (int i = 0; i < cha; i++) {
            cnt2[s.charAt(i) - 'a']--;
            cnt2[s.charAt(n + i) - 'a']++;
            if (Arrays.equals(cnt1,cnt2)) {
                result.add(i + 1);
            }
        }
        return result;
    }
}

package com.ustc.leetcode.datastrcture.string;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 3. 无重复字符的最长子串
 */
public class L3 {
    /**
     * 时间上有待改进
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        HashSet<Character> maxSubString = new HashSet<>(); // 当前最长子串
        HashSet<Character> beforMaxString = new HashSet<>(); // 以前一个字符结尾的不重复的最长子串
        maxSubString.add(chars[0]);
        beforMaxString.add(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            // 当前第i个位置的字符在 beforMaxString 中时， 重新计算
            if (beforMaxString.contains(chars[i])) {
                // 重新计算before
                beforMaxString = calculateBeforMaxString(s, i);
            } else {
                beforMaxString.add(chars[i]);
            }
            if (beforMaxString.size() >= maxSubString.size()) {
                maxSubString = beforMaxString;
            }
        }
        return maxSubString.size();
    }

    /**
     * 找出以第i个位置的字符结尾的不重复的最长子串
     * @param s
     * @param index
     * @return
     */
    private HashSet<Character> calculateBeforMaxString(String s, int index) {

        HashSet<Character> beforMaxString = new HashSet<>();
        for (int i = index; i > 0; i--) {
            if (!beforMaxString.contains(s.charAt(i))) {
                beforMaxString.add(s.charAt(i));
            } else {
                return beforMaxString;
            }
        }
        return beforMaxString;
    }
}

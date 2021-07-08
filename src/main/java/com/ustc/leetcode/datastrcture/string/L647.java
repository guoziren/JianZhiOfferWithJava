package com.ustc.leetcode.datastrcture.string;

/**
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * 647. 回文子串
 */
public class L647 {
    /**
     * 待优化
     * 时间 击败了 5.03%的用户
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int result = 0;
        for (int len = 1; len <= length; len++) {
            for (int i = 0; i + len <= length; i++) {
                String target = s.substring(i,i + len);
                result = isHuiwen(target) ? ++result : result;
            }
        }
        return result;
    }

    public boolean isHuiwen(String target) {
        if (target.length() == 1) {
            return true;
        }
        char[] chars = target.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }
}

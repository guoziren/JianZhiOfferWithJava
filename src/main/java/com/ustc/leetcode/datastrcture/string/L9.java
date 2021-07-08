package com.ustc.leetcode.datastrcture.string;

public class L9 {
    public static void main(String[] args) {
        new L9().isPalindrome(-5);
    }

    public boolean isPalindrome(int x) {
        // 下面的注释掉更快
//        if (x < 0) {
//            return false;
//        }
//        if (x == 0) {
//            return true;
//        }
        String source = String.valueOf(x);
        return isHuiwen(source);

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

package com.ustc.leetcode.datastrcture.string;

/**
 * 字符串转换整数 (atoi)
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnoilh/
 */
public class StringJunior1 {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        String trim = s.trim();
        // 去除空格是空串
        if (trim.equals("")) {
            return 0;
        }
        // 取出符号位
        char c = trim.charAt(0);
        int sign = 1;
        boolean isFirstIsSign = true;
        if (c == '+') {
            sign = 1;
        } else if (c == '-') {
            sign = -1;
        } else {
            isFirstIsSign = false;
        }
        // 第1位是否为符号位
        int begin = isFirstIsSign ? 1 : 0;
        char[] chars = trim.toCharArray();
        String num = "";
        for (int i = begin; i < chars.length; i++) {
            if (isNumber(chars[i])) {
                num += chars[i];
                Long result = Long.valueOf(num);
                if (sign > 0 && result >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (sign < 0 && result * sign <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        if (num.equals("")) {
            return 0;
        }
        return sign * Integer.valueOf(num);
    }

    private boolean isNumber(char c) {
        return c - '0' >= 0 && c - '0' <= 9;
    }
}

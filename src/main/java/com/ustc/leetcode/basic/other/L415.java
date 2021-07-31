package com.ustc.leetcode.basic.other;

public class L415 {

    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int jinwei = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int n1 = num1.charAt(i) - '0';
            int n2 = num2.charAt(j) - '0';
            int computeResult = n1 + n2 + jinwei ;
            if (computeResult >= 10) {
                computeResult = computeResult - 10;
                jinwei = 1;
            } else {
                jinwei = 0;
            }
            sb.insert(0, computeResult);
            i--;
            j--;
        }
        while (i >= 0) {
            int n1 = num1.charAt(i) - '0';
            int computeResult = n1 + jinwei;
            if (computeResult >= 10) {
                computeResult = computeResult - 10;
                jinwei = 1;
            } else {
                jinwei = 0;
            }
            sb.insert(0, computeResult);
            i--;
        }
        while (j >= 0) {
            int n2 = num2.charAt(j) - '0';
            int computeResult = n2 + jinwei;
            if (computeResult >= 10) {
                computeResult = computeResult - 10;
                jinwei = 1;
            } else {
                jinwei = 0;
            }
            sb.insert(0, computeResult);
            j--;
        }
        if (jinwei > 0) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}

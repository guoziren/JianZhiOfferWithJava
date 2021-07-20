package com.ustc.leetcode.basic.other;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 17. 电话号码的字母组合
 */
public class L17 {
    public static List<List<String>> dict = new ArrayList<>();

    static {
        for (int i = 0; i < 8; i++) {
            dict.add(new ArrayList<>());
        }
        int begin = 0;
        int j = 0;
        for (char i = 'a'; i <= 'o'; i++) {
            dict.get(begin).add(String.valueOf(i));
            j++;
            if (j == 3) {
                j = 0;
                begin++;
            }

        }
        dict.get(begin).add("p");
        dict.get(begin).add("q");
        dict.get(begin).add("r");
        dict.get(begin).add("s");
        begin++;
        dict.get(begin).add("t");
        dict.get(begin).add("u");
        dict.get(begin).add("v");
        begin++;
        dict.get(begin).add("w");
        dict.get(begin).add("x");
        dict.get(begin).add("y");
        dict.get(begin).add("z");

    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        char[] array = digits.toCharArray();
        int length = array.length;
        List<String> list1 = dict.get(array[0] - '0' - 2);
        List<String> list2 = null;
        List<String> list3 = null;
        List<String> list4 = null;
        if (length >= 2) {
            list2 = dict.get(array[1] - '0' - 2);
        }
        if (length >= 3) {
            list3 = dict.get(array[2] - '0' - 2);
        }
        if (length >= 4) {
            list4 = dict.get(array[3] - '0' - 2);
        }

        char[] cc = new char[digits.length()];
        for (String s1 : list1) {
            cc[0] = s1.charAt(0);
            if (list2 != null) {
                for (String s2 : list2) {
                    cc[1] = s2.charAt(0);
                    if (list3 != null) {
                        for (String s3 : list3) {
                            cc[2] = s3.charAt(0);
                            if (list4 != null) {
                                for (String s4 : list4) {
                                    cc[3] = s4.charAt(0);
                                    result.add(new String(cc));
                                }
                            } else {
                                result.add(new String(cc));
                            }
                        }
                    } else {
                        result.add(new String(cc));
                    }
                }
            } else {
                result.add(new String(cc));
            }
        }
        return result;
    }
}

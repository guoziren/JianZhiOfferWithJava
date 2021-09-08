package com.ustc.leetcode.datastrcture.string;


import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 402. 移掉 K 位数字
 * https://leetcode-cn.com/problems/remove-k-digits/
 */
public class L402 {
    /**
     * 注意：
     * 1.remain是要保留的个数，下面的算法k会变，因此要在k变之前计算reamin
     * 2.删除前面的0， 因为字符串个数可能超过int表示的最大范围的数字个数， 不能用Integer.paseInt
     * 3.结果多个0的情况
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();
        int remain = num.length() - k;
        for (char c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > c ) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        ListIterator<Character> iterator = stack.listIterator(stack.size());
        StringBuilder sb = new StringBuilder();
        while (iterator.hasPrevious() && remain > 0) {
            sb.append(iterator.previous());
            remain--;
        }
        String s = sb.toString();
        if (s.equals("")) {
            return "0";
        }
        // 删除前面的0， 因为字符串个数可能超过int表示的最大范围的数字个数， 不能用Integer.paseInt
        int index = -1;
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (s.charAt(i) != '0') {
                index = i;
                break;
            }
        }
        // 多个0的情况，index 为-1
        if (index == -1) {
            return "0";
        }
        return s.substring(index);
    }
}

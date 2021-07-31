package com.ustc.leetcode.algorithmidea.backtracking;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/palindrome-partitioning/submissions/
 * 131. 分割回文串
 */
public class L131 {
    public static void main(String[] args) {
        L131 l131 = new L131();
//        l131.partition("aab");
        l131.partition("abba");
//        l131.partition("abc");
    }

    /**
     * 子串有2的n - 1次个， 比如aab 有 aab 不划     a|ab 划一刀  aa|b 划一刀   a|a|b 划2刀 ， 加起来是2的 n - 1次
     * 用回溯(深度优先遍历)找出所有划分，然后判断每个划分中的所有子串是不是回文
     * 判断回文 可才有动态规划，先把所有结果保存起来
     *
     * 考察： 时间复杂度 n * 2的n次方, 就是这么大 不要怕
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.length() == 1){
            result.add(Arrays.asList(s));
            return result;
        }
        boolean[][] table = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i >= j) {
                    table[i][j] = true;
                } else {
                    table[i][j] = isHuiwen(s.substring(i,j + 1));
                }
            }
        }
        if (table[0][s.length()-1]) {
            result.add(Arrays.asList(s));
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int len = 1; len < s.length(); len++) {
            for (int i = 1; i < s.length() ; i++) {
                dfs(len, i, 1, s, result, list, table);
            }

        }
        System.out.println(result);
        return result;
    }


    /**
     *
     * @param len 划分划几刀， 划1刀则分为2个子串，从划1刀开始
     * @param begin 从哪开始遍历， 从1 开始，其实就是找一个序列的所有组合
     * @param length 当前串的长度，从1开始
     * @param s 原字符串
     * @param result 结果集合
     * @param list 辅助栈
     * @param table 动态规划查表
     */
    private void dfs(int len, int begin, int length, String s, List<List<String>> result, LinkedList<Integer> list, boolean[][] table) {
        if (length > len) {
            return;
        }

        list.push(begin);
        if (len == length) {
            addOne(result, list, table, s);
        }
        // 深度优先遍历
        for (int j = begin + 1; j < s.length(); j++) {
            dfs(len , j , length + 1, s, result, list, table);
        }
        list.pop();


    }

    private void addOne(List<List<String>> result, LinkedList<Integer> list, boolean[][] table, String s) {
        List<Integer> index = new ArrayList<>(); // 划分的索引集合， 首部添加0， 末尾添加 字符串的长度
        index.add(0);
        // 逆序
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            index.add(listIterator.previous());
        }
        index.add(s.length());
        List<String> temp = new ArrayList<>(); // 当前划分的所有子串都是回文才添加到结果集
        boolean flag = true;
        for (int i = 0; i < index.size() - 1; i++) {
            String substring = s.substring(index.get(i), index.get(i + 1));
            if (table[index.get(i)][index.get(i + 1) - 1]) {
//                System.out.println(substring);
                temp.add(substring);
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            result.add(temp);
        }
    }


    private boolean isHuiwen(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }
}

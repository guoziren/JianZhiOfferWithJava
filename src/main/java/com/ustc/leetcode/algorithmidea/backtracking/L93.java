package com.ustc.leetcode.algorithmidea.backtracking;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 * 前导0 ，理解有误，开始是子串长度为2时，2个都是0 不符合条件，实际是第一位不是0即可。
 * 第5层退出代码要放在 加入结果列表之后判断
 * 93. 复原 IP 地址
 */
public class L93 {
    /**
     * 通过，时间击败了74%, 但是写的代码时间较长。
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4) {
            return result;
        }
        LinkedList<String> stack = new LinkedList<>();
        dfs(s, 0, result, 1, stack);
        return result;
    }

    private void dfs(String s, int begin ,List<String> result, int level, LinkedList<String> stack) {

        if (level > 1 && s.length() - begin > (4 - level + 1) * 3) {
            return;
        }
        if (level > 4) {
            ListIterator<String> iterator = stack.listIterator(stack.size());
            StringBuilder sb = new StringBuilder();
            while (iterator.hasPrevious()) {
                String next = iterator.previous();
                sb.append(next + ".");
            }
            String substring = sb.substring(0, sb.toString().length() - 1);
            result.add(substring);
            return;
        }
        if (begin >= s.length()) {
            return;
        }

        for (int i = begin + 1; i <= begin + 3; i++) {
            if (i > s.length()) {
                continue;
            }
            String substring = s.substring(begin, i);
            if (substring.length() == 2 && substring.charAt(0) == '0') {
                continue;
            }
            if (substring.length() == 3 && substring.charAt(0) == '0') {
                continue;
            }
            if (Integer.parseInt(substring) > 255) {
                continue;
            }
            stack.push(substring);
            dfs(s,i,result, level + 1, stack);
            stack.pop();
        }
    }
}

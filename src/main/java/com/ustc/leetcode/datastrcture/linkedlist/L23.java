package com.ustc.leetcode.datastrcture.linkedlist;

import com.ustc.Main;
import com.ustc.common.ListNode;
import com.ustc.common.ListNodeUtil;

public class L23 {
    public static void main(String[] args) {
        ListNode h1 = ListNodeUtil.createFromArrayWithoutHead(new int[]{1, 3}, 2);
        ListNode h2 = ListNodeUtil.createFromArrayWithoutHead(new int[]{2, 4}, 2);
        ListNode merge = new L23().merge(h1, h2);
        ListNodeUtil.printWithoutHead(merge);

        ListNode[] listNodes = new ListNode[]{
                ListNodeUtil.createFromArrayWithoutHead(new int[]{1, 4, 5}, 3),
                ListNodeUtil.createFromArrayWithoutHead(new int[]{1, 3, 4}, 3),
                ListNodeUtil.createFromArrayWithoutHead(new int[]{2, 6}, 2)};
        ListNode node = new L23().mergeKLists(listNodes);
        ListNodeUtil.printWithoutHead(node);
    }


    /**
     * 合并n个有序链表：采用2个2个合并
     * 这样暴力也可以, 只是时间较慢
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode result = merge(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            result = merge(result, lists[i]);
        }
        return result;
    }

    /**
     * 合并2个有序链表
     *
     * @param h1
     * @param h2
     * @return
     */
    public ListNode merge(ListNode h1, ListNode h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        ListNode result = null;
        if (h1.val < h2.val) {
            h1.next = merge(h1.next, h2);
            result = h1;
        } else {
            h2.next = merge(h1, h2.next);
            result = h2;
        }
        return result;
    }
}

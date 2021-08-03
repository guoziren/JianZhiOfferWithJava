package com.ustc.leetcode.datastrcture.linkedlist;

import com.ustc.common.ListNode;

/**
 * @author: lycguo
 * @since: 2021/8/3
 */
public class L92 {

    /**
     * 仅遍历一遍 实现
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        if (left == right) {
            return head;
        }
        int k = right - left + 1;
        if (left == 1) {
            return reverseK(head,k);
        }

        ListNode p = head;
        int index = 1;
        ListNode pre = null;
        while (index < left) {
            pre = p;
            p = p.next;
            index++;
        }
        pre.next = reverseK(p, k);
        return head;
    }

    /**
     * 从head开始 翻转k个节点
     * @param head
     * @param k
     * @return
     */
    private ListNode reverseK(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        if (k < 2) {
            return head;
        }
        ListNode pre = null, cur = head, next = null;
        while (k > 0) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            k--;
        }
        head.next = next;
        return pre;
    }

}

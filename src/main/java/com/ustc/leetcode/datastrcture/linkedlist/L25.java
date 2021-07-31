package com.ustc.leetcode.datastrcture.linkedlist;

import com.ustc.common.ListNode;

/**
 * 25. K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class L25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode  preTail = null;
        ListNode curHead = head;
        ListNode nextHead = head;
        boolean isFirstReverse = true;
        ListNode resultHead = head;
        while (nextHead != null) {
            boolean flag = true; // 是否够, 开始是够的
            for (int i = 0; i < k; i++) {
                if (nextHead != null) {
                    nextHead = nextHead.next;
                } else {
                    flag = false;
                }

            }
            // 如果不够
            // 先判断flag, flag 为false则不必反转, 此时curHead指向了新的节点
            if (!flag) {
                if (preTail != null) {
                    preTail.next = curHead;
                }
                break;
            }
            // 如果够

            // 1.反转当前的，
            ListNode afterReverseHead = reverseK(curHead, k);
            if (isFirstReverse) {
                isFirstReverse = false;
                resultHead = afterReverseHead;
            }
            // 2.前面的尾巴指向当前的头
            if (preTail != null) {
                preTail.next = afterReverseHead;
            }
            preTail = curHead;
            curHead = nextHead;
        }
        return resultHead;
    }

    /**
     * 反转链表的头k个节点, 调用方需保证链表节点>=k个
     * @param head 原始链表头节点
     * @param k 反转的个数
     * @return 返回反转后的链表头结点， 参数head将变为尾结点
     */
    public ListNode reverseK(ListNode head,int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode pre = null, cur = head;
        for (int i = k; i > 0; i--) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

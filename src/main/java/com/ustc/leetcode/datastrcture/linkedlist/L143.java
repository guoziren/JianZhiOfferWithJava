package com.ustc.leetcode.datastrcture.linkedlist;

import com.ustc.common.ListNode;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 * 143. 重排链表
 */
public class L143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        // 大于2个节点
        // 1. 找到中间节点, 后半部分的头结点
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode nextHead = slow.next;
        slow.next = null;
        ListNode secondHead = nextHead;
        // 2. 翻转后半部分
        secondHead = reverse(secondHead);
        // 3. 间隔插入前半部分
        ListNode p1 = head, p2 = secondHead;
        while (p1 != null && p2 != null) {
            ListNode p1Next = p1.next;
            ListNode p2Next = p2.next;
            p1.next = p2;
            p2.next = p1Next;
            p2 = p2Next;
            p1 = p1Next;
        }
        return;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode next= cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

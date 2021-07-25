package com.ustc.leetcode.datastrcture.linkedlist;

import com.ustc.common.ListNode;

/**
 * https://leetcode-cn.com/problems/sort-list/
 * 148. 排序链表
 */
public class L148 {
    /**
     * 参考冒泡排序的思想，时间复杂度O(n方)  超时了。
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        p = head;
        ListNode pre = null;
        for (int i = len; i > 1; i--) {
            for (int j = 1; j < i; j++) {
                if (p.val > p.next.val) {
                    // 交换
                    if (j == 1) {
                        head = p.next;
                    }
                    if (pre != null) {
                        pre.next = p.next;
                    }
                    pre = p.next;
                    ListNode temp = p.next.next;
                    p.next.next = p;
                    p.next = temp;
                } else {
                    pre = p;
                    p = p.next;
                }
            }
            pre = null;
            p = head;
        }
        return head;
    }

    /**
     * 利用归并(自底向上) + 合并2个有序链表   时间： O(nlogn)
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

}

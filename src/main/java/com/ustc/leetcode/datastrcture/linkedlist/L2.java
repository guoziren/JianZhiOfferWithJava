package com.ustc.leetcode.datastrcture.linkedlist;

import com.ustc.common.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 2. 两数相加
 *
 */
public class L2 {
    /**
     * easy 顺序遍历链表即可
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinwei = 0;
        ListNode current = null;
        ListNode first = null;
        while (l1 != null && l2 != null) {
            int newVal = l1.val + l2.val + jinwei;
            if (newVal >= 10) {
                newVal = newVal - 10;
                jinwei = 1;
            } else {
                jinwei = 0;
            }
            ListNode listNode = new ListNode(newVal);
            if (current == null) {
                current = listNode;
                first = listNode;
            } else  {
                current.next = listNode;
                current = listNode;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int newVal = l1.val + jinwei;
            if (newVal >= 10) {
                newVal = 0;
                jinwei = 1;
            } else {
                jinwei = 0;
            }
            ListNode listNode = new ListNode(newVal);
            current.next = listNode;
            current = listNode;
            l1 = l1.next;
        }
        while (l2 != null) {
            int newVal = l2.val + jinwei;
            if (newVal >= 10) {
                newVal = 0;
                jinwei = 1;
            } else {
                jinwei = 0;
            }
            ListNode listNode = new ListNode(newVal);
            current.next = listNode;
            current = listNode;
            l2 = l2.next;
        }
        if (jinwei == 1) {
            current.next = new ListNode(1);
        }
        return first;
    }
}




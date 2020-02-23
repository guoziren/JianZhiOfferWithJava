package com.ustc.leetcode;

import com.ustc.common.ListNode;
import com.ustc.common.ListNodeUtil;

public class L206 {
    public static void main(String[] args) {

        //构造链表
        int arr[] = {1};
        ListNode head = ListNodeUtil.createFromArrayWithoutHead( arr, 1);
        //正向输出
        ListNodeUtil.printWithoutHead(head);

        head = reverseList(head);
        ListNodeUtil.printWithoutHead(head);
    }
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode pCur = head;
        ListNode pNext = null;
        while (pCur != null){
            pNext = pCur.next;
            pCur.next = pre;
            pre = pCur;
            pCur = pNext;
        }
        return pre;
    }

    /**
     * 递归方式
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}

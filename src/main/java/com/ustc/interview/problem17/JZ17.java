package com.ustc.interview.problem17;

import com.ustc.common.ListNode;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 *
 *
 *
 *
 */
public class JZ17 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode head = null;
        if(l1.val > l2.val){
            head = l2;
            head.next = mergeTwoLists(l1,l2.next);
        }else{
            head = l1;
            head.next = mergeTwoLists(l1.next,l2);
        }
        return head;
    }

}

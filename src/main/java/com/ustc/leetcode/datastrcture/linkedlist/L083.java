package com.ustc.leetcode.datastrcture.linkedlist;

import com.ustc.common.ListNode;
import com.ustc.common.ListNodeUtil;
import org.junit.Test;

/**
 * 83. 删除排序链表中的重复元素
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class L083 {
    @Test
    public void test1(){
        int[] arr = {1,1,2,3,3};
        ListNode head = ListNodeUtil.createFromArrayWithoutHead(arr,arr.length);
        deleteDuplicates(head);
        ListNodeUtil.printWithoutHead(head);
    }
    @Test
    public void test2(){
        int[] arr = {1,1,2};
        ListNode head = ListNodeUtil.createFromArrayWithoutHead(arr,arr.length);
        deleteDuplicates(head);
        ListNodeUtil.printWithoutHead(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null){
            while (p1.val == p2.val){
                p2 = p2.next;
                if (p2 == null){
                    p1.next = null;
                    return head;
                }
            }
            p1.next = p2;
            p1 = p2;
            p2 = p2.next;
        }
        return head;
    }
}

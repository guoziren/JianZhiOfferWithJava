package com.ustc.leetcode;

import com.ustc.common.ListNode;
import com.ustc.common.ListNodeUtil;
import org.junit.Test;

public class LInterview18 {
    @Test
    public void test(){
        int[] arr = {4,5,1,9};
        ListNode head = ListNodeUtil.createFromArrayWithoutHead(arr,4);
        head = deleteNode(head,4);
        ListNodeUtil.printWithoutHead(head);
    }
    @Test
    public void test2(){
        int[] arr = {4,5,1,9};
        ListNode head = ListNodeUtil.createFromArrayWithoutHead(arr,4);
        head = deleteNode(head,5);
        ListNodeUtil.printWithoutHead(head);
    }
    @Test
    public void test22(){
        int[] arr = {4,5,1,9};
        ListNode head = ListNodeUtil.createFromArrayWithoutHead(arr,4);
        head = deleteNode(head,1);
        ListNodeUtil.printWithoutHead(head);
    }
    @Test
    public void test3(){
        int[] arr = {4,5,1,9};
        ListNode head = ListNodeUtil.createFromArrayWithoutHead(arr,4);
        head =  deleteNode(head,9);
        ListNodeUtil.printWithoutHead(head);
    }
    @Test
    public void test4(){
        int[] arr = {4};
        ListNode head = ListNodeUtil.createFromArrayWithoutHead(arr,1);
        head =   deleteNode(head,4);
        ListNodeUtil.printWithoutHead(head);
    }
    @Test
    public void test5(){
        int[] arr = {};
        ListNode head = ListNodeUtil.createFromArrayWithoutHead(arr,0);
        head =   deleteNode(head,9);
        ListNodeUtil.printWithoutHead(head);
    }

    /**
     * 没有头指针
     * @param head 链表的第一个结点
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null || head.next == null){
            return null;
        }
        if (head.val == val){
            return head.next;
        }
        ListNode point = head;
        while (point.next.val != val){
            point = point.next;
        }
        point.next = point.next.next;
        return head;
    }



}

package com.ustc.leetcode;

import com.ustc.common.ListNode;
import com.ustc.common.ListNodeUtil;
import org.junit.Test;

import java.util.List;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 */
public class L024 {
    @Test
    public void test1(){
        int arr[] = {1};
        ListNode head = ListNodeUtil.createFromArrayWithoutHead(arr,arr.length);
        ListNodeUtil.printWithoutHead(head);
        head = swapPairs(head);
        ListNodeUtil.printWithoutHead(head);
    }
    @Test
    public void test2(){
        int arr[] = {1,2};
        ListNode head = ListNodeUtil.createFromArrayWithoutHead(arr,arr.length);
        ListNodeUtil.printWithoutHead(head);
        head = swapPairs(head);
        ListNodeUtil.printWithoutHead(head);
    }
    @Test
    public void test3(){
        int arr[] = {1,2,3};
        ListNode head = ListNodeUtil.createFromArrayWithoutHead(arr,arr.length);
        ListNodeUtil.printWithoutHead(head);
        head = swapPairs(head);
        ListNodeUtil.printWithoutHead(head);
    }
    @Test
    public void test4(){
        int arr[] = {1,2,3,4};
        ListNode head = ListNodeUtil.createFromArrayWithoutHead(arr,arr.length);
        ListNodeUtil.printWithoutHead(head);
        head = swapPairs(head);
        ListNodeUtil.printWithoutHead(head);
    }
    @Test
    public void test5(){
        int arr[] = {1,2,3,4,5};
        ListNode head = ListNodeUtil.createFromArrayWithoutHead(arr,arr.length);
        ListNodeUtil.printWithoutHead(head);
        head = swapPairs(head);
        ListNodeUtil.printWithoutHead(head);
    }

    /**
     * 从2个结点，4个结点开始分析，再考虑一些特殊情况，就不难了
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode p1 = head;
        ListNode result = head.next;
        ListNode p2 = head.next;
        ListNode temp = head;
        while (temp != null && temp.next != null){

            temp = p2.next;
            p2.next = p1;
            if (temp == null){
                p1.next = null;
            }else if (temp != null && temp.next == null){
                p1.next = temp;
                p2 = temp.next;
            }else{
                p1.next = temp.next;
                p2 = temp.next;
            }
            p1 = temp;
        }
        return result;
    }
}

package com.ustc.leetcode.datastrcture.linkedlist;

import com.ustc.common.ListNode;
import com.ustc.common.ListNodeUtil;
import org.junit.Test;

public class L021 {
    public static void main(String[] args) {


    }

    /**
     * l1空，l2不空
     */
    @Test
    public void test1(){
        int[] arr = {1,3,5};
        ListNode l2 = ListNodeUtil.createFromArrayWithoutHead(arr,3);
        ListNode result =  mergeTwoLists(null,l2);
        ListNodeUtil.printWithoutHead(result);
    }
    /**
     * l2空，l1不空
     */
    @Test
    public void test2(){
        int[] arr = {1,3,5};
        ListNode l2 = ListNodeUtil.createFromArrayWithoutHead(arr,3);
        ListNode result =  mergeTwoLists(null,l2);
        ListNodeUtil.printWithoutHead(result);
    }
    /**
     * l1不空，l2不空,l1,l2没有相同的结点
     */
    @Test
    public void test3(){
        int[] arr = {1,3,5};
        int[] arr2 = {2,4,6};
        ListNode l1 = ListNodeUtil.createFromArrayWithoutHead(arr,3);
        ListNodeUtil.printWithoutHead(l1);
        ListNode l2 = ListNodeUtil.createFromArrayWithoutHead(arr2,3);
        ListNodeUtil.printWithoutHead(l2);
        ListNode result =  mergeTwoLists(l1,l2);
        ListNodeUtil.printWithoutHead(result);
    }
    /**
     * l1不空，l2不空,l1,l2有相同的结点
     */
    @Test
    public void test4(){
        int[] arr = {1,3,5};
        int[] arr2 = {2,3,6};
        ListNode l1 = ListNodeUtil.createFromArrayWithoutHead(arr,3);
        ListNodeUtil.printWithoutHead(l1);
        ListNode l2 = ListNodeUtil.createFromArrayWithoutHead(arr2,3);
        ListNodeUtil.printWithoutHead(l2);
        ListNode result =  mergeTwoLists(l1,l2);
        ListNodeUtil.printWithoutHead(result);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode head = null;
        if (l1.val < l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next,l2);
        }else {
            head = l2;
            head.next = mergeTwoLists(l1,l2.next);
        }
        return head;
    }
}

package com.ustc.leetcode.datastrcture.linkedlist;

import com.ustc.common.ListNode;
import com.ustc.common.ListNodeUtil;
import org.junit.Test;

/**
 * 328. 奇偶链表
 * https://leetcode-cn.com/problems/odd-even-linked-list/description/
 * Note:解决链表问题最好的办法是在脑中或者纸上把链表画出来。
 */
public class L328 {
    @Test
    public void test1(){
        int[] arr = {1,2,3,4,5};
        ListNode head = ListNodeUtil.createFromArrayWithoutHead(arr,arr.length);
        oddEvenList(head);
        ListNodeUtil.printWithoutHead(head);
    }
    @Test
    public void test2(){
        int[] arr = {2,1,3,5,6,4,7};
        ListNode head = ListNodeUtil.createFromArrayWithoutHead(arr,arr.length);
        oddEvenList(head);
        ListNodeUtil.printWithoutHead(head);
    }
    @Test
    public void test3(){
        int[] arr = {};
        ListNode head = ListNodeUtil.createFromArrayWithoutHead(arr,arr.length);
        oddEvenList(head);
        ListNodeUtil.printWithoutHead(head);
    }

    /**
     * 需遍历求链表长度后分奇偶处理的方法，需要四个指针
     * 时间复杂度O(n),空间复杂度O(1)
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null){
            return head;
        }
        int length = 1;
        ListNode p1 = head;
        while (p1.next != null){
            p1 = p1.next;
            length++;
        }
        //奇数和偶数分别处理
        p1 = head;
        ListNode p2 = head.next;
        ListNode even = head.next;
        if (length % 2 == 0){
            while (p2.next != null){
                p1.next = p2.next;
                p1 = p1.next;
                p2.next = p1.next;
                p2 = p2.next;
            }
            p1.next = even;
        }else{
            while (true){
                p1.next = p2.next;
                p1 = p1.next;
                if (p1.next == null){
                    p2.next = null;
                    p1.next = even;
                    break;
                }else{
                    p2.next = p1.next;
                    p2 = p2.next;
                }
            }
        }
        return head;
    }

}

package com.ustc.leetcode;

import com.ustc.common.ListNode;
import com.ustc.common.ListNodeUtil;
import org.junit.Test;

public class L019 {
    @Test
    public void test1(){
        int arr[] = {1,2,3,4,5};
        int arr1[] = {1,2};
        int arr2[] = {1,2,3};
        ListNode head = ListNodeUtil.createFromArrayWithoutHead(arr,5);
        ListNodeUtil.printWithoutHead(head);
        head = removeNthFromEnd2(head,1);
        ListNodeUtil.printWithoutHead(head);

    }



    /**
     * 删除倒数第n个结点（这是遍历2遍的方法）
     * 删除链表的结点分为3类：①第一个结点②倒第一个结点③中间结点：找到前一个结点，删除后面的结点
     * @param head
     * @param n  倒数第n(最后1个结点是倒数第一，而不是倒数第0，第一个结点索引就是1)
     * @return 删除后的链表头结点
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        //如果删除的是第一个结点
        if (n == len) {
            return head.next;
            //如果删除的是最后一个结点
        } else if (n == 1) {
            cur = head;
            for (int i = 0; i < len - 1 - 1; i++) {
                cur = cur.next;
            }
            cur.next = null;
            //如果是中间结点
        } else {
            cur = head;
            for (int i = 0; i < len - n - 1; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;

        }
        return head;
    }
}

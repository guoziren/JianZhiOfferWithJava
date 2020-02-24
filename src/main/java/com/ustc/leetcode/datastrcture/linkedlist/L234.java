package com.ustc.leetcode.datastrcture.linkedlist;

import com.ustc.common.ListNode;
import com.ustc.common.ListNodeUtil;
import org.junit.Test;

/**
 * 234. 回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/description/
 * 方法一：将值复制到数组中后用双指针法；时间复杂度O(n),空间复杂度O(n)
 * 方法二：避免O(n)额外空间的方法就是改变输入：
 * ①链表后半部分翻转，比较后恢复原样
 * ②或者链表后半部分头插法挪到前面，比较后恢复原样
 * 时间复杂度O(n),空间复杂度O(1)
 * 缺点：并发环境下，方法运行时需要上锁，因为执行过程中修改了链表。
 */

public class L234 {
    @Test
    public void test(){
        int[] arr = {1,2,2,1,3};

        ListNode head = ListNodeUtil.createFromArrayWithoutHead(arr,arr.length);
        System.out.println( isPalindrome(head));
        ListNodeUtil.printWithoutHead(head);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        boolean result = true;
        int length = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = head;
        while (p1 != null){
            length++;
            p1 = p1.next;
        }
        //后半部分挪到前面
        p1 = head;
        ListNode p2 = head;
        int position = 1;
        if (length % 2 == 0){
            while (position < length / 2){
                p2 = p2.next;
                position++;
            }
            while (p2.next != null){
                ListNode temp = p2.next;
                p2.next = temp.next;
                temp.next = dummy.next;
                dummy.next = temp;
            }

        }else{
            while (position < length / 2 + 1){
                p2 = p2.next;
                position++;
            }
            while (p2.next != null){
                ListNode temp = p2.next;
                p2.next = temp.next;
                temp.next = dummy.next;
                dummy.next = temp;
            }
        }
        p2 = head;
        p1 = dummy.next;
        //开始比较
        position = 1;
        while (position <= length / 2){
            if (p1.val != p2.val){
                result = false;
            }
            if (p2.next != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            position++;
        }
        //挪回去,原来的结构不希望改变

        while (p2.next != null){
            p2 = p2.next;
        }
        position = 1;
        while (position <= length / 2){
            if (p2.next == null){
                p2.next = dummy.next;
                dummy.next = dummy.next.next;
                p2.next.next = null;
            }else{
                p1 = p2.next;
                p2.next = dummy.next;
                dummy.next = dummy.next.next;
                p2.next.next = p1;

            }

            position++;
        }

        return result;
    }
}

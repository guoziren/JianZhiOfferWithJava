package com.ustc.common;

import java.util.Stack;

public class ListNodeUtil {
    /**
     * 创建链表头结点
     *
     * @return返回头结点
     */
    public static ListNode createHead() {
        return new ListNode();
    }

    /**
     * 向链表末尾插入一个新节点
     *
     * @param pHead 头结点
     * @param val
     * @return 返回是否插入成功
     */
    public static boolean addToTail(ListNode pHead, int val) {
        if (pHead == null) {
            return false;
        }
        ListNode pNew = new ListNode(val);
        ListNode pre = pHead;//遍历指针
        while (pre.next != null) {
            pre = pre.next;
        }
        pre.next = pNew;
        return true;
    }

    /**
     * 正向输出链表(不输出表头,头结点没有值)
     *
     * @param pHead
     */
    public static void print(ListNode pHead) {
        if (pHead == null) {
            System.out.println("头结点为null");
        }
        while (pHead.next != null) {
            if (pHead.next.next != null) {
                System.out.print(pHead.next.val + "->");
            } else {
                System.out.print(pHead.next.val + "\n");
            }
            pHead = pHead.next;
        }
    }
    /**
     * 正向输出链表(输出全部结点，没有没有值的头结点)
     *
     * @param pHead
     */
    public static void printWithoutHead(ListNode pHead) {
        if (pHead == null) {
            System.out.println("这是个空链表");
        }
        ListNode pCur = pHead;
        while (pCur != null) {
            if (pCur.next != null) {
                System.out.print(pCur.val + "->");
            } else {
                System.out.print(pCur.val + "\n");
            }
            pCur = pCur.next;
        }
    }

    /**
     * 反向输出链表
     *
     * @param pHead
     */
    public static void printReverse(ListNode pHead) {
        if (pHead == null) {
            System.out.println("头结点为null");
        }
        Stack<Integer> stack = new Stack<Integer>();
        while (pHead.next != null) {
            stack.push(pHead.next.val);
            pHead = pHead.next;
        }
        while (!stack.empty()) {
            int res = stack.pop();
            if (stack.empty()) {
                System.out.print(res + "\n");
            } else {
                System.out.print(res + "->");
            }

        }
    }

    /**
     * 从给定数组中创建带头结点(头结点没有值)链表
     * @param pHead
     * @param arr
     * @param size
     */
    public static void createFromArray(ListNode pHead, int[] arr, int size) {
        if (pHead == null || arr == null || size <= 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            addToTail(pHead, arr[i]);
        }
    }

    public static ListNode createFromArrayWithoutHead( int[] arr, int size) {
        if ( arr == null || size <= 0) {
            return null;
        }
        ListNode node = new ListNode(arr[0]);
        for (int i = 1; i < size; i++) {
            addToTail(node, arr[i]);
        }
        return node;
    }

    /**
     * 递归反向输出
     *
     * @param pHead
     */
    public static void printRecursion(ListNode pHead) {
        if (pHead == null) {
            return;
        }
        printRecursion(pHead.next);
        System.out.println(pHead.val);
    }

    /**
     * 递归反向输出，书上的写法
     * @param pHead
     */
    public static void printRecursion1(ListNode pHead) {
        if (pHead != null) {
            if (pHead.next != null) {
                printRecursion1(pHead.next);
            }
            System.out.println(pHead.val);
        }
    }
}

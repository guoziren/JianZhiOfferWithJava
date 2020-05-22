package com.ustc.interview.problem6;

import com.ustc.common.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * 修改链表结构：
 * 方法零：节点指针反转过来
 * 不能修改链表结构：
 * 方法一：循环 + Stack
 * 方法二：递归
 */
public class InterviewProblem6 {
    public static void main(String[] args) {
        ListNode pHead = createHead();
        //构造链表
        int arr[] = {1, 3, 2, 4, 5};
        createFromArray(pHead, arr, 5);
        //正向输出
        print(pHead);
        //反向输出
        printReverse(pHead);
        //递归反向输出
        printRecursion(pHead);
    }

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
     * 正向输出链表
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

    public static void createFromArray(ListNode pHead, int[] arr, int size) {
        if (pHead == null || arr == null || size <= 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            addToTail(pHead, arr[i]);
        }
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

    //剑指offer 牛客网版本,递归版本
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

}

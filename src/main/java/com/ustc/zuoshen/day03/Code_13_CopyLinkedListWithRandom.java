package com.ustc.zuoshen.day03;

import com.ustc.zuoshen.util.Duishuqi;
import org.junit.Test;

import java.util.HashMap;

/**
 * 题目13
 */
public class Code_13_CopyLinkedListWithRandom {
    class LinkedListNode   {
        public int val;
        public LinkedListNode next;
        public LinkedListNode random;
        LinkedListNode(int val){
            this.val = val;
        }
    }
    //额外空间复杂度O(N)
    public LinkedListNode copyListWithRand1(LinkedListNode head){
        if (head == null){
            return null;
        }
        HashMap<LinkedListNode,LinkedListNode> map = new HashMap<>();
        LinkedListNode p1 = head;
        while (p1 != null){
            LinkedListNode node = new LinkedListNode(p1.val);
            map.put(p1,node);
            p1 = p1.next;
        }
        p1 = head;
        while (p1 != null){
            map.get(p1).next = p1.next == null ? null : map.get(p1.next);
            map.get(p1).random = p1.random == null ? null : map.get(p1.random);
            p1 = p1.next;
        }
        return map.get(head);
    }
    //额外空间复杂度O(1)
    public LinkedListNode copyListWithRand2(LinkedListNode head){
        if (head == null){
            return null;
        }
        LinkedListNode p1 = head;
        LinkedListNode p2 = null;
        //①->②->③->null  变成 ①->①`->②->②`->③->③`->null
        while (p1 != null){
            p2  = p1.next;
            LinkedListNode copyNode = new LinkedListNode(p1.val);
            copyNode.next = p2;
            p1.next = copyNode;
            p1 = p2;
        }
        p1 = head;
        p2 = head.next;
        //set copy node random
        while (p2 != null && p2.next != null){
            p2.random = p1.random == null ? null : p1.random.next;
            p1 = p1.next.next;
            p2 = p2.next.next;
        }
        p1 = head;
        p2 = head.next;
        LinkedListNode result = head.next;
        //split
        while (p2 != null && p2.next != null){
            p1.next = p1.next.next;
            p2.next = p2.next.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p2.next == null){
            p1.next = null;
        }
        return result;
    }

    @Test
    /**
     * 测试
     */
    public void test(){
        int[] arr = Duishuqi.generateRandomArray(20,200);
//        int[] arr = {};
        LinkedListNode head = createFromArray(arr,arr.length);
        print(head);
        LinkedListNode copy = copyListWithRand2(head);
        print(head);
        print(copy);
    }
    void print(LinkedListNode head){
        if (head == null){
            System.out.println("这是个空链表");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (head != null){
            String s =  head.next == null ? head.val + "" : head.val + "->";
            head = head.next;
          sb.append(s);
        }
        System.out.println(sb.toString());
    }
    public  boolean addToTail(LinkedListNode pHead, int val) {
        if (pHead == null) {
            return false;
        }
        LinkedListNode pNew = new LinkedListNode(val);
        LinkedListNode pre = pHead;//遍历指针
        while (pre.next != null) {
            pre = pre.next;
        }
        pre.next = pNew;
        return true;
    }
    public  LinkedListNode createFromArray( int[] arr, int size) {
        if ( arr == null || size <= 0) {
            return null;
        }
        LinkedListNode node = new LinkedListNode(arr[0]);
        for (int i = 1; i < size; i++) {
            addToTail(node, arr[i]);
        }
        return node;
    }
    
}

package com.ustc.leetcode.datastrcture.linkedlist;

import java.util.HashMap;

/**
 * 138. 复制带随机指针的链表
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */
public class L138 {
    /**
     * 不难。
     * 用2个Map, 假设链表像数组一样有下标，也从0开始。
     * 一个保存原节点所在数组的位置，一个保存新链表对应数组的位置
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node,Integer> map = new HashMap<>(); // 保存原节点所在数组的位置，
        HashMap<Integer,Node> map2 = new HashMap<>(); // 保存新链表对应数组的位置
        Node p = head;
        int i = 0;
        Node newHead = null;
        Node pre = null;

        while (p != null) {
            map.put(p, i);
            // 拷贝链表
            Node node = new Node(p.val);

            if (pre == null) {
                pre = node;
                newHead = node;
            } else {
                pre.next = node;
                pre = node;
            }
            map2.put(i, node);
            i++;
            p = p.next;
        }
        // 复制随机指针
        // 从map1找到原链表的随机指针，指向的位置， 从map2根据位置找新的节点
        p = head;
        Node q = newHead;
        while (p != null) {
            Integer position = map.get(p.random);
            Node node = map2.get(position);
            q.random = node;
            q = q.next;
            p = p.next;
        }
        return newHead;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}


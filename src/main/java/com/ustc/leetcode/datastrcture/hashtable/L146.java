package com.ustc.leetcode.datastrcture.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 *  146. LRU缓存机制
 *  https://leetcode-cn.com/problems/lru-cache/
 */

public class L146 {

}
class LRUCache{
    class DLinkNode{
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;
        public DLinkNode(){}

        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;

        }

    }
    private Map<Integer,DLinkNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkNode head,tail;

    public LRUCache( int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.head = new DLinkNode();
        this.tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key){
        DLinkNode node = cache.get(key);
        if (node == null){
            return -1;
        }
        //如果key存在，先通过hashtable定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    public void put(int key,int value){
        DLinkNode node = cache.get(key);
        if (node == null){
            DLinkNode newNode = new DLinkNode(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity){
                DLinkNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    private DLinkNode removeTail() {
        DLinkNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private void removeNode(DLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 插入到Head结点后,head结点是伪结点
     * @param newNode
     */
    private void addToHead(DLinkNode newNode) {
        newNode.prev = head;
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
    }

}
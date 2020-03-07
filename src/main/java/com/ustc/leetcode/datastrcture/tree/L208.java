package com.ustc.leetcode.datastrcture.tree;



import org.junit.Test;

/**
 * 208. 实现 Trie (前缀树)
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
public class L208 {
    private Node node;
    public L208(){
        node = new Node();
    }
    class Node{
        public int path;
        public int end;
        public Node[] next;

        public Node() {
            this.path = 0;
            this.end = 0;
            //初始认为当前结点到a-z共26边均为空或者说没有路径
            this.next = new Node[26];

        }
    }

    /**
     * 插入一个字符串
     * @param word
     */
    public void insert(String word){
        char[] chars = word.toLowerCase().toCharArray();
        int len = chars.length;
        Node temp = null;
        Node p = node;
        for (int i = 0; i < len; i++) {
            int index = chars[i] - 'a';
            if (p.next[index] == null){
                temp = new Node();
                temp.path = 1;
                p.next[index] = temp;
            }else{
                temp = p.next[index];
                temp.path++;
            }
            if (i == len - 1){
                temp.end++;
            }
            p = temp;
        }
    }

    public boolean startsWith(String word){
        char[] chars = word.toLowerCase().toCharArray();
        int len = chars.length;
        Node temp = node;

        for (int i = 0; i < len; i++) {
            int index = chars[i] - 'a';
            if(temp.next[index] == null){
                return false;
            }
            temp = temp.next[index];
        }
        return true;
    }

    public boolean search(String word){
        char[] chars = word.toLowerCase().toCharArray();
        int len = chars.length;
        Node p = node;
        for (int i = 0; i < len; i++) {
            int index = chars[i] - 'a';
            if (p.next[index] == null){
                return false;
            }
            p = p.next[index];
        }
        return  p.end >= 1 ? true : false;
    }

}

package com.ustc.zuoshen.day07;

import org.junit.Test;

/**
 *  实现 Trie (前缀树)
 */
public class TrieTree {
    private Node node;
    public TrieTree(){
        node = new Node();
    }
    class Node{
        public int path;
        public int end;
        public Node[] next;

        public Node() {
            this.path = 0;
            this.end = 0;
            this.next = new Node[26];
        }
    }
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
    public void insertStringArray(String[] s){
        for (String s1 : s) {
            insert(s1);
        }
    }

    /**
     *
     * @param prefix 前缀
     * @return 前缀树中以word为前缀的字符串的个数
     */
    public int startsWith(String prefix){
        char[] chars = prefix.toLowerCase().toCharArray();
        int len = chars.length;
        Node temp = node;

        for (int i = 0; i < len; i++) {
            int index = chars[i] - 'a';
            if(temp.next[index] == null){
                return 0;
            }
            temp = temp.next[index];
        }
        return temp.path;
    }

    /**
     *
     * @param word
     * @return 前缀树中word字符串的个数
     */
    public int search(String word){
        char[] chars = word.toLowerCase().toCharArray();
        int len = chars.length;
        Node p = node;
        for (int i = 0; i < len; i++) {
            int index = chars[i] - 'a';
            if (p.next[index] == null){
                return 0;
            }
            p = p.next[index];
        }
        return  p.end ;
    }

    @Test
    public void test(){
        TrieTree trie = new TrieTree();
        String[] array = {"abc","ab","bc","bcd"};
        trie.insertStringArray(array);
        System.out.println(trie.startsWith("ab"));
        System.out.println(trie.startsWith("abc"));
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("abcd"));
    }

}

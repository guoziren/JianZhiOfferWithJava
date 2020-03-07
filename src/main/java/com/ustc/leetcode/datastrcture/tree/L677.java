package com.ustc.leetcode.datastrcture.tree;

import org.junit.Test;

import java.util.*;

/**
 * 677. 键值映射
 * https://leetcode-cn.com/problems/map-sum-pairs/description/
 */
public class L677 {
    private Node root = null;

    class Node {
        public HashSet<Character> set;//记录含有的边，重复不记录
        public int val;//字符串末尾时,insert方法参数赋值给val
        public boolean isEnd;//是否是字符串末尾
        public Node[] next;
        Node() {
            isEnd = false;
            val = 0;
            set = new HashSet<>();
            next = new Node[52];//初始化为到52个字母的边都为null
        }
    }

    public L677() {
        root = new Node();
    }

    public void insert(String key, int val) {
        if (key == null || key.length() == 0) {
            return;
        }
        char[] charArray = key.toCharArray();
        int len = charArray.length;
        Node p = root;
        for (int i = 0; i < len; i++) {
            int position = getPosition(charArray[i]);
            if (p.next[position] == null){
                p.next[position] = new Node();
            }
            p.set.add(charArray[i]);
            p = p.next[position];
            if (i == len - 1){
                p.val = val;
                p.isEnd = true;
            }
        }
    }

    private int getPosition(char c) {
        //A-Za-z
        if (c >= 'A' && c <= 'Z'){
            return c - 'A';
        }else if(c >= 'a' && c <='z'){
            return c - 'a' + 26;
        }else{
            return -1;
        }
    }

    public int sum(String prefix) {
        if (prefix == null || prefix.length() == 0){
            return 0;
        }
        int len =  prefix.length();
        char[] chars = prefix.toCharArray();
        Node p = root;
        for (int i = 0; i < len; i++) {
            int position = getPosition(chars[i]);
            if (p.next[position] == null){
                return 0;
            }
            p = p.next[position];
        }
        int sum = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(p);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            if (temp.isEnd){
                sum += temp.val;
            }
            for (Character character : temp.set) {
                int position = getPosition(character);
                queue.add(temp.next[position]);
            }
        }
        return sum;
    }
    @Test
    public void test(){
        L677 obj = new L677();
        obj.insert("aa",3);
        System.out.println("null");
        System.out.println(obj.sum("a"));
        obj.insert("aa",2);
        System.out.println("null");
        System.out.println(obj.sum("a"));
        System.out.println(obj.sum("aa"));
        obj.insert("aaa",3);
        System.out.println("null");
        System.out.println(obj.sum("aaa"));
        System.out.println(obj.sum("bbb"));
        System.out.println(obj.sum("ccc"));
        obj.insert("aewfwaefjeoawefjwoeajfowajfoewajfoawefjeowajfowaj",111);
        System.out.println("null");
        System.out.println(obj.sum("aa"));
        System.out.println(obj.sum("a"));

    }
    //方法二
    class MapSum {
        private HashMap<String,Integer> map;


        public MapSum() {
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            map.put(key,val);
        }

        public int sum(String prefix) {
            int sum = 0;
            for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
                 if(stringIntegerEntry.getKey().startsWith(prefix)){
                     sum += stringIntegerEntry.getValue();
                 }
            }
            return sum;
        }
    }
}

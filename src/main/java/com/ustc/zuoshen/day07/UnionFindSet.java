package com.ustc.zuoshen.day07;

import java.util.HashMap;
import java.util.List;

public class UnionFindSet {
    static class Node{

    }
    private HashMap<Node,Node> fatherMap;//key : child , value : father
    private HashMap<Node,Integer> sizeMap;
    public UnionFindSet(List<Node> nodes){
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        for (Node node : nodes) {
            fatherMap.put(node,node);
            sizeMap.put(node,1);
        }
    }
    private Node findHead(Node node){
        Node father = fatherMap.get(node);
        if (father != node){
            father = findHead(father);
        }
        fatherMap.put(node,father);
        return father;
    }
    public boolean isSameSet(Node a,Node b){
        return findHead(a) == findHead(b);
    }
    public void union(Node a ,Node b){
        if (a == null || b == null){
            return;
        }
        Node aHead = findHead(a);
        Node bHead = findHead(b);
        if (aHead != bHead){
            int aSetSize = sizeMap.get(aHead);
            int bSetSize = sizeMap.get(bHead);
            if (aSetSize <= bSetSize){
                fatherMap.put(aHead,bHead);
                sizeMap.put(bHead,aSetSize + bSetSize);

            }else {
                fatherMap.put(bHead,aHead);
                sizeMap.put(aHead,aSetSize + bSetSize);
            }
        }

    }

}

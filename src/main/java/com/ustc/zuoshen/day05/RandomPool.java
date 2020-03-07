package com.ustc.zuoshen.day05;

import java.util.HashMap;

public class RandomPool<K> {
    private HashMap<K,Integer> map1 ;
    private HashMap<Integer,K> map2 ;
    private int size;

    public RandomPool() {
        this.map1 = new HashMap<>();
        this.map2 = new HashMap<>();
        this.size = 0;
    }
    public void add(K k){
        map1.put(k,size);
        map2.put(size++,k);
    }
    public K getRandom(){
        if (size == 0){
            return null;
        }
        int index = (int)(Math.random() * size);
        return map2.get(index);
    }
    public void delete(K k){
        if (map1.containsKey(k)){
            int index = map1.get(k);
            K lastK = map2.get(size - 1);
            map1.put(lastK,index);
            map1.remove(k);

            map2.put(index,lastK);
            map2.remove(size-1);
            size--;
        }
    }
}

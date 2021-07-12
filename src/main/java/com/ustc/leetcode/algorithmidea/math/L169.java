package com.ustc.leetcode.algorithmidea.math;

import java.util.HashMap;
import java.util.Map;

public class L169 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            putNum(map, num);
        }
        int maxValue = -1;
        int maxKey = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    private void putNum(Map<Integer, Integer> map, int num) {
        Integer value = map.getOrDefault(num, 0);
        map.put(num, ++value);
    }
}

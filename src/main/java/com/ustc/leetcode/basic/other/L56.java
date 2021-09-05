package com.ustc.leetcode.basic.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class L56 {
    /**
     * 排个序先
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list= new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            // 有重复
            if (intervals[i][0] <= current[1]) {
                int second = intervals[i][1] > current[1] ? intervals[i][1] : current[1];
                current = new int[]{current[0],second};
            } else {
                list.add(current);
                current = intervals[i];
            }
        }
        list.add(current);
        int[][] ints = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }
}

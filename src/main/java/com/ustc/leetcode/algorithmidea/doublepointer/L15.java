package com.ustc.leetcode.algorithmidea.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 * 15. 三数之和
 */
public class L15 {
    /**
     * 1.排序后优化
     * 2.优化：保持位置 first < second < third
     * 3.优化: first,second 与前一个重复时，跳过
     * 4.优化: third从右往左. 双指针法，2个值，一个随着另一个的增大而减小时，用双指针可以从O(N方)降到O(N), 为什么?
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        // 拷贝
        int[] array = nums;
        // 排序
        Arrays.sort(array);
        // 处理
        for (int i = 0; i < array.length; i++) {
            // 跳过相等的
            if (i != 0 && array[i] == array[i-1]){
                continue;
            }
            for (int j = i + 1; j < array.length - 1; j++) {
                // 跳过相等的
                if (j != i + 1 && array[j] == array[j-1]) {
                    continue;
                }
                int k = array.length - 1;
                while (array[i] + array[j] + array[k] > 0 && j + 1 < k) {
                    k--;
                }
                if (array[i] + array[j] + array[k] == 0) {
                    //添加
                    result.add(Arrays.asList(array[i], array[j], array[k]));
                }
            }
        }
        return result;
    }
}

package com.ustc.leetcode.datastrcture.arrayandmatrix;

import java.util.HashSet;

/**
 *  565. 数组嵌套
 *  https://leetcode-cn.com/problems/array-nesting/description/
 */
public class L565 {
    //此解法没有visited数组，超出时间限制，有了后时间上击败30+%;
    public int arrayNesting(int[] nums) {
        int index = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        int maxLen = 0;
        boolean[] visited = new boolean[nums.length];
        for (int num : nums) {
            index = num;
            while (!hashSet.contains(nums[index]) && visited[nums[index]] == false){
                visited[nums[index]] = true;
                hashSet.add(nums[index]);
                index = nums[index];
            }
            maxLen = Math.max(hashSet.size(),maxLen);

            hashSet.clear();
        }
        return maxLen;
    }
    //时间复杂度O(N)，空间复杂度O(n)
    //不需要hashset，最后判断结束是会等于起始的值
    public int arrayNesting2(int[] nums) {
        int index = 0;
        int maxLen = 0;
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index = nums[i];
            int count = 1;
            visited[i] = true;
            while ( nums[index] != nums[i] && visited[index] == false){
                visited[index] = true;
                index = nums[index];
                count++;
            }
            maxLen = Math.max(count,maxLen);
            count = 1;
        }
        return maxLen;
    }
}

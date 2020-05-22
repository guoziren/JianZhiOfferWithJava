package com.ustc.leetcode.datastrcture.hashtable;

import java.util.HashMap;

/**
 *  594. 最长和谐子序列
 *  https://leetcode-cn.com/problems/longest-harmonious-subsequence/description/
 */
public class L594 {
    //时间复杂度O(N),空间复杂度O(N),执行用时33~50ms，时间击败了29~73%
    public int findLHS(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num,map.get(num) + 1);
            }else{
                map.put(num,1);
            }
        }
        int longestLength = 0;
        for (int num : nums) {
            int len = map.get(num);
            int l1 = map.get(num - 1) == null ? 0 : map.get(num - 1);
            int l2 = map.get(num + 1) == null ? 0 : map.get(num + 1);
            if (l1 != 0 || l2 != 0){

                longestLength = Math.max(Math.max(l1,l2) + len, longestLength);
            }
        }
        return longestLength;
    }
}

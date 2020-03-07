package com.ustc.leetcode.algorithmidea.binarysearch;

/**
 * 278. 第一个错误的版本
 * https://leetcode-cn.com/problems/first-bad-version/
 */
public class L278 {
    public int firstBadVersion(int n) {

        int low = 1;
        int high = n;
        while (low <= high){
            int mid = (low + high) >>> 1;
            if (isBadVersion(mid)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isBadVersion(int i) {
        return false;
    }

}

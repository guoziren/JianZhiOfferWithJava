package com.ustc.interview.problem53;

public class Problem2 {
    public int missingNumber(int[] nums) {

        int low = 0, high = nums.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (nums[mid] == mid){
                low = mid + 1;
            }else if(nums[mid] > mid){
                if (mid == 0 || nums[mid - 1] == mid - 1){
                    return mid ;
                }
                high = mid - 1;

            }
        }
        if (low == nums.length){
            return low;
        }
        return -1;
    }


}

package com.ustc.interview.problem53;

import org.junit.Test;

public class InterviewProblem53 {
    @Test
    public void test(){
        int[] arr = new int[]{1};
        System.out.println(GetNumberOfK(arr,-1));
    }
    public int GetNumberOfK(int [] array , int k) {
        int left = findFirstPosition(array,k);
        if (left == -1){
            return 0;
        }
        int right = findLastPosition(array,k);
        return right - left + 1;
    }

    private int findLastPosition(int[] array, int k) {
        int low = 0,high = array.length - 1;
        int mid = 0;
        while (low <= high){
            mid = low + (high - low) / 2;
            if (array[mid] > k){
                high = mid - 1;
            }else if(array[mid] < k){
                low = mid + 1;
            }else{
                if (mid  == array.length - 1 || array[mid + 1] != k){
                    return mid;
                }else{
                    low = mid + 1;
                }
            }
        }
       return -1;
    }

    private int findFirstPosition(int[] array, int k) {
        int low = 0,high = array.length - 1;
        int mid = 0;
        while (low <= high){
            mid = low + (high - low) / 2;
            if (array[mid] > k){
                high = mid - 1;
            }else if(array[mid] < k){
                low = mid + 1;
            }else{
                if (mid  == 0 || array[mid - 1] != k){
                    return mid;
                }else{
                    high = mid -1;
                }
            }
        }
        return -1;
    }

}

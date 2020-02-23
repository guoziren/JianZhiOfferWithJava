package com.ustc.interview.problem3;

/**
 * 面试题3：数组中重复的数字
 */
public class InterviewProblem3 {
    public static void main(String[] args) {
        int arr[] = {2,3,5,4,3,2,6,7};

       int result = getDuplication(arr,8);
        System.out.println(result);
    }

    /**
     * 题目二：找出数组numbers中一个重复的数字,算法时间复杂度O(nlogn),空间复杂度O(1)
     * @param numbers 给定一个数组
     * @param length 数组长度
     * @return
     */
    public static int getDuplication(int numbers[],int length){
        if (numbers == null || length <= 0){
            return -1;
        }
        int start = 1;//起始数字
        int end = length - 1;//末尾数字
        while (end >= start){
            int middle = start + ((end - start) >> 1);
            int count = countRange(numbers,length,start,middle);
            if (end == start){
                if (count > 1){
                    return start;
                }else {
                    break;
                }
            }
            if (count > (middle -start + 1)){
                end = middle;//重复数字在左边
            }else{
                start = middle + 1;//重复数字在右边
            }
        }
        return -1;
    }

    /**
     * 找出[start,end]范围内的数字在原数组中出现的个数
     * @param numbers 原数组
     * @param length 原数组的长度
     * @param start 起始数字
     * @param end 末尾数字
     * @return
     */
    private static int countRange(int[] numbers, int length, int start, int end) {
        if (numbers == null){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (numbers[i] >= start && numbers[i] <= end){
                ++count;
            }
        }
        return count;
    }
}

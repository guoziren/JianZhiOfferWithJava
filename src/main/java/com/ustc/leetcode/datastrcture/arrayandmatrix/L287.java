package com.ustc.leetcode.datastrcture.arrayandmatrix;

/**
 *  287. 寻找重复数
 *  https://leetcode-cn.com/problems/find-the-duplicate-number/description/
 */
public class L287 {
    //
    //

    /**【时间复杂度O(N),空间复杂度O(1)】
     * 不能排序，不能改变原数组，只能O(1)的额外空间，怎么办？
     * 方法三，什么叫必须存在一个环？
     * ①设nums的长度为n + 1 ,索引从0~n，n+1个数只能指向1-n范围的树
     * ②将nums看成一个单链表(静态链表),index为值,nums[index]为指针
     * ③可知必然存在环
     * 然后用单链表 快慢指针的方法查找环
     * //入环的第一个结点必有2个指针指向他，也即重复的value
     * @param nums
     * @return 重复的数
     */
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        fast = nums[nums[0]];
        slow = nums[0];
        while (fast != slow){
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        fast = 0;
        while (fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}

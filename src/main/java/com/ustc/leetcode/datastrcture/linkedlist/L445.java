package com.ustc.leetcode.datastrcture.linkedlist;

import com.ustc.common.ListNode;
import com.ustc.common.ListNodeUtil;
import org.junit.Test;

/**
 * 445. 两数相加 II
 * https://leetcode-cn.com/problems/add-two-numbers-ii/description/
 */
public class L445 {
    @Test
    public void test(){
        int[] arr1 = {7,2,4,3};
        int[] arr2 = {5,6,4};
        ListNode l1 = ListNodeUtil.createFromArrayWithoutHead(arr1,arr1.length);
        ListNode l2 = ListNodeUtil.createFromArrayWithoutHead(arr2,arr2.length);
        l1 = addTwoNumbers(l1,l2);
        ListNodeUtil.printWithoutHead(l1);
    }

    /**
     * 输入5，5，输出，1，0的这种情况没考虑到;
     * 输入9->9,1 这种情况也没考虑到；
     * 总结 ： 考虑（测试）不全面，多种特殊情况没考虑到
     * 思路：
     * ①考虑到大数的情况，遍历2个链表，转为2个字符串
     * ②从后往前遍历2个字符串数组，字符相加，考虑进位
     * ③每相加一次生成一个新的结点指向前一个结点
     * ④对未遍历完的字符数组，构造结点添加到链表头，这里要考虑到进位情况
     * （时间复杂度O(n),空间复杂度O(n)）
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (l1 != null){
            sb1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            sb2.append(l2.val);
                l2 = l2.next;
        }
        String s1 = sb1.toString();
        String s2 = sb2.toString();
        int len1 = s1.length() - 1;
        int len2 = s2.length() - 1;
        ListNode pre = null;
        int jinwei = 0;
        int result = 0;
        for (; len1 >= 0 && len2 >= 0 ; len1--,len2--) {
            char c1 = s1.charAt(len1);
            char c2 = s2.charAt(len2);
             result = addTwoChar( c1, c2, jinwei);
            if (result >= 10){
                result = result - 10;
                jinwei = 1;
            }else{
                jinwei = 0;
            }
            ListNode newNode = new ListNode(result);
            newNode.next = pre;
            pre = newNode;
        }
        while (len1 >= 0){
            if (jinwei == 1){
              result  = s1.charAt(len1) - '0' + jinwei;
                if (result >= 10){
                    result = result - 10;
                    jinwei = 1;
                }else{
                    jinwei = 0;
                }
            }else{
                result  = s1.charAt(len1) - '0';
            }
            len1--;
            ListNode newNode = new ListNode(result);
            newNode.next = pre;
            pre = newNode;
        }
        while (len2 >= 0){
            if (jinwei == 1){
                result  = s2.charAt(len2) - '0' + jinwei;
                if (result >= 10){
                    result = result - 10;
                    jinwei = 1;
                }else{
                    jinwei = 0;
                }
            }else{
                result  = s2.charAt(len2) - '0';
            }
            len2--;
            ListNode newNode = new ListNode(result);
            newNode.next = pre;
            pre = newNode;
        }
        if (jinwei == 1){
            ListNode newNode = new ListNode(jinwei);
            newNode.next = pre;
            pre = newNode;
        }
        return pre;
    }
    public int addTwoChar(char c1,char c2,int jinwei){
          int a1 = c1 - '0';
          int a2 = c2 - '0';
          return a1+a2 +jinwei;
    }
}

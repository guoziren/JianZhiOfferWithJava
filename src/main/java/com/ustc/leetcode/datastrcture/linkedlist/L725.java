package com.ustc.leetcode.datastrcture.linkedlist;

import com.ustc.common.ListNode;
import com.ustc.common.ListNodeUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 725. 分隔链表
 * https://leetcode-cn.com/problems/split-linked-list-in-parts/description/
 * Note:
 * ①list转数组 list.toArray(new Object[size]) 为正确用法;
 *   list转数组 (Object[])list.toArray() 容易出错;
 * ②算法描述：
 *   1）遍历1次求链表长度
 *   2) 计算分离后的各链表长度
 *   3) 遍历1次分离
 * 时间复杂度:O(n),空间复杂度:O(1)
 */
public class L725 {
    @Test
    public void test(){
        int[] arr = {};
        int[] arr2 = {1,2,3,4,5,6,7,8,9,10};
        ListNode root = ListNodeUtil.createFromArrayWithoutHead(arr,arr.length);

         ListNode[] nodes = splitListToParts(root,5);
        for (ListNode node : nodes) {
            ListNodeUtil.printWithoutHead(node);
        }
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        List<ListNode> listNodes = new ArrayList<ListNode>();
        //数组初始化的方式？
        if (root == null){
            for (int i = 0; i < k; i++) {
                listNodes.add(null);
            }
            return  listNodes.toArray(new ListNode[k]);
        }


        int length = 1;
        ListNode p1 = root;
        while (p1.next != null){
            p1 = p1.next;
            length++;
        }
        int shang = length / k;
        int yushu = length % k;
        p1 = root;
        ListNode p2 = root;
        if (shang == 0){
            while (p1.next != null){
                 p2 = p2.next;
                p1.next = null;
                listNodes.add(p1);
                p1 = p2;
            }
            listNodes.add(p1);
            for (int i = 0; i < k - yushu ; i++) {
                listNodes.add(null);
            }
        }else{
           int[] arr = new int[k];

            for (int i = 0; i < k; i++) {
                arr[i] = shang;
                if (yushu > 0){
                    arr[i] = arr[i] + 1;
                    yushu--;
                }
            }
            for (int i = 0; i < k; i++) {
                int len = arr[i];//分离后的链表长度
                while (len > 0){
                    len--;
                    if (len == 0){
                        if (p2.next == null){
                            listNodes.add(p1);
                        }else {
                            ListNode temp = p2.next;
                            p2.next = null;
                            listNodes.add(p1);
                            p1 = temp;
                            p2 = temp;
                        }
                    }else {
                        p2 = p2.next;
                    }
                }
            }
        }
        return listNodes.toArray(new ListNode[k]);
    }
}

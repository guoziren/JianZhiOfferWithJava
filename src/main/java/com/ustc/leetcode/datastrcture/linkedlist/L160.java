package com.ustc.leetcode.datastrcture.linkedlist;

import com.ustc.common.ListNode;

/**
 * 160. 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/description/
 * 方法二：哈希表法（易理解）,时间复杂度O(m+n),空间复杂度O(m)或O(n)
 *          基于相交以及后面的部分是一样的，是一条链表，比较引用/地址是否在哈希表中
 * 方法三：双指针法（不易理解，参考题解有图示），时间复杂度O(m+n),空间复杂度O(1)
 *
 * 这个题跟结点的值val不太有关系，比较的是引用,也就是当指向的是同一个对象时，即为交点
 */
public class L160 {
    /**
     * 方法一 长链表先走几步
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0,lenB = 0;
        lenA = length(headA);
        lenB = length(headB);
        int distance = lenA - lenB;
        if (distance >= 0 ){
            while (distance > 0){
                distance--;
                headA = headA.next;
            }
            while (headA != null && headB != null && headA != headB){
                headA = headA.next;
                headB = headB.next;
            }
            if (headA == null){
                return null;
            }else{
                return headA;
            }
        }else {
            while (distance < 0){
                distance++;
                headB = headB.next;
            }
            while (headA != null && headB != null && headA != headB){
                headA = headA.next;
                headB = headB.next;
            }
            if (headA == null){
                return null;
            }else{
                return headA;
            }
        }

    }
    public int length(ListNode root){
        ListNode cur = root;
        int len = 0;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        return len;
    }


}

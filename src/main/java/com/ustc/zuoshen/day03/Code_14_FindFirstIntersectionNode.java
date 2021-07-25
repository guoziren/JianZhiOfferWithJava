package com.ustc.zuoshen.day03;

import com.ustc.common.ListNode;

import java.util.HashSet;

/**
 * 题目14 单链表相交
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/description/
 */
public class Code_14_FindFirstIntersectionNode {
    /**
     *  包括了有环和无环的情况
     * @param headA 链表A的头结点
     * @param headB 链表B的头结点
     * @return 两个链表相交的起始节点，不存在则返回null
     */
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        ListNode loopNodeA = getLoopNode2(headA);
        ListNode loopNodeB = getLoopNode2(headB);
        //2个无环单链表
        if (loopNodeA == null && loopNodeB == null){
            return  getNoLoopIntersectionNode(headA,headB);
        //2个有环单链表
        }else if(loopNodeA != null && loopNodeB != null){
            return getLoopIntersectionNode(headA,headB);
        }
        //一个有环和一个无环单链表是否相交：结论-->不相交
        return null;
    }



//   1)如何判断单链表有环?法一
    /** 哈希表法，额外空间复杂度O(N)
     * 从给定链表中返回第一个入环节点
     * @param head 链表头结点
     * @return 如果存在环，返回环的起点，否则返回Null
     */
    public ListNode getLoopNode1(ListNode head){
        if (head == null || head.next == null){
            return null;
        }
       HashSet<ListNode> hashSet = new HashSet<>();
        while (true){
            if (head.next == null){
                return null;
            }
            if (hashSet.contains(head)){
                return head;
            }
            hashSet.add(head);
            head = head.next;
        }
    }

     //1)如何判断单链表有环?法二
    /**
     * leetcode L142 https://leetcode-cn.com/problems/linked-list-cycle-ii/
     * 不用哈希表（很玄学，这里有个结论）额外空间复杂度O(1)
     * 从给定链表中返回第一个入环节点
     * @param head 链表头结点
     * @return 如果存在环，返回环的起点，否则返回Null
     */
    public ListNode getLoopNode2(ListNode head){
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null && slow != fast){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null || fast.next == null){
            return null;
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

//2)如何判断2个无环单链表相交，并返回交点(用哈希表)；法一
//easy 未做实现
//public ListNode getNoLoopIntersectionNode(ListNode headA,ListNode headB){}

//2)如何判断2个无环单链表相交，并返回交点（不用哈希表,记录长度）；法二【时间复杂度O(m+n),空间O(1)】
    /**
     * 判断2个无环单链表相交，并返回交点；
     * 1.比较最后一个结点，若不一样，则肯定无交点
     * 2.如果有，应从相同长度的地方开始比较
     * @return 相交的起始节点,不存在则返回null
     */
    public ListNode getNoLoopIntersectionNode(ListNode headA,ListNode headB){
        if (headA == null || headB == null){
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        int len1 = 1;
        int len2 = 1;
        while (p1.next != null){
            p1 = p1.next;
            len1++;
        }
        while (p2.next != null){
            p2 = p2.next;
            len2++;
        }
        if (p1 != p2){
            return null;
        }
        p1 = headA;
        p2 = headB;
        return getFirstInsectionNodeInExist(p1, p2, len1, len2);

    }

    /**
     * 两个无环单链表有相交节点的情况下和
     * 两个有环单链表有相交结点且入环结点相同情况下
     * 返回第一个相交的结点
     * @param p1 链表1的头结点
     * @param p2 链表2的头结点
     * @param len1 链表1的长度
     * @param len2 链表2的长度
     * @return
     */
    private ListNode getFirstInsectionNodeInExist(ListNode p1, ListNode p2, int len1, int len2) {
        if (len1 >= len2){
            while (len1 - len2 >0){
                p1 = p1.next;
                len1--;
            }
            while (p1 != p2){
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        }else {
            while (len2 - len1 >0){
                p2 = p2.next;
                len2--;
            }
            while (p1 != p2){
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        }
    }

    //- 不用哈希表，也不用记录长度;
//
//3)如何判断2个有环单链表相交3种情况
    public ListNode getLoopIntersectionNode(ListNode headA,ListNode headB){
         ListNode loopNodeA = getLoopNode1(headA);
         ListNode loopNodeB = getLoopNode1(headB);
         if (loopNodeA == null || loopNodeB == null){
             return null;
         }
         //入环结点相同
         if (loopNodeA == loopNodeB){
             int lenA = 1;
             int lenB = 1;
             ListNode p1 = headA;
             ListNode p2 = headB;
             while (p1.next != null){
                 p1 = p1.next;
                 lenA++;
             } while (p2.next != null){
                 p2 = p2.next;
                 lenB++;
             }
             p1 = headA;
             p2 = headB;
             return  getFirstInsectionNodeInExist(p1,p2,lenA,lenB);


         }else{
             ListNode p1 = loopNodeA;
             //入环结点不同时，标识是否有交点
             boolean flag = false;
             while (p1.next != loopNodeA){
                 p1 = p1.next;
                 if (p1 == loopNodeB){
                     flag = true;
                     break;
                 }
             }
             //两种情形
             if (flag){
                 //也可以返回loopNodeB
                 return loopNodeA;
             }else {
                 return null;
             }
         }
    }


}

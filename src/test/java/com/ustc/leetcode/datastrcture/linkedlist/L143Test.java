package com.ustc.leetcode.datastrcture.linkedlist;

import static org.junit.Assert.*;

import com.ustc.common.ListNode;
import com.ustc.common.ListNodeUtil;
import org.junit.Test;

public class L143Test {

    @Test
    public void reorderList() {
        L143 l143 = new L143();
        ListNode f1 = ListNodeUtil.createFromArrayWithoutHead(new int[]{1}, 1);
        ListNode f2 = ListNodeUtil.createFromArrayWithoutHead(new int[]{1,2}, 2);
        ListNode f3 = ListNodeUtil.createFromArrayWithoutHead(new int[]{1,2,3}, 3);
        ListNode f4 = ListNodeUtil.createFromArrayWithoutHead(new int[]{1,2,3,4}, 4);
        ListNode f5 = ListNodeUtil.createFromArrayWithoutHead(new int[]{1,2,3,4,5}, 5);
        l143.reorderList(f1);
        l143.reorderList(f2);
        l143.reorderList(f3);
        l143.reorderList(f4);
        l143.reorderList(f5);
        ListNodeUtil.printWithoutHead(f1);
        ListNodeUtil.printWithoutHead(f2);
        ListNodeUtil.printWithoutHead(f3);
        ListNodeUtil.printWithoutHead(f4);
        ListNodeUtil.printWithoutHead(f5);
    }
}
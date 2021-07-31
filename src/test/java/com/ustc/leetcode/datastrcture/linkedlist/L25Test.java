package com.ustc.leetcode.datastrcture.linkedlist;

import com.ustc.common.ListNode;
import com.ustc.common.ListNodeUtil;
import org.junit.Test;

public class L25Test {

    @Test
    public void reverseKGroup() {
        L25 l25 = new L25();
        ListNode fromArrayWithoutHead = ListNodeUtil.createFromArrayWithoutHead(new int[]{1, 2, 3, 4, 5}, 5);
        ListNode listNode = l25.reverseKGroup(fromArrayWithoutHead, 2);
        ListNodeUtil.printWithoutHead(listNode);

        fromArrayWithoutHead = ListNodeUtil.createFromArrayWithoutHead(new int[]{1, 2}, 2);
        listNode = l25.reverseKGroup(fromArrayWithoutHead, 2);
        ListNodeUtil.printWithoutHead(listNode);

        fromArrayWithoutHead = ListNodeUtil.createFromArrayWithoutHead(new int[]{1, 2, 3, 4}, 4);
        listNode = l25.reverseKGroup(fromArrayWithoutHead, 2);
        ListNodeUtil.printWithoutHead(listNode);

    }
}
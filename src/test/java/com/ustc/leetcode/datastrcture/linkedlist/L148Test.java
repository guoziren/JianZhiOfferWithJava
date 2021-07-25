package com.ustc.leetcode.datastrcture.linkedlist;

import com.ustc.common.ListNode;
import com.ustc.common.ListNodeUtil;
import org.junit.Assert;
import org.junit.Test;

public class L148Test {

    @Test
    public void sortList2() {
        L148 l148 = new L148();
        ListNode head = ListNodeUtil.createFromArrayWithoutHead(new int[]{1, 3, 2, 4}, 4);
        head = l148.sortList2(head);
        Assert.assertEquals(1, head.val);

        head = ListNodeUtil.createFromArrayWithoutHead(new int[]{1, 2, 3, 4}, 4);
        head = l148.sortList2(head);
        Assert.assertEquals(1, head.val);

        head = ListNodeUtil.createFromArrayWithoutHead(new int[]{4, 3, 2, 1}, 4);
        head = l148.sortList2(head);
        Assert.assertEquals(1, head.val);

        head = ListNodeUtil.createFromArrayWithoutHead(new int[]{1, 4, 2, 3}, 4);
        head = l148.sortList2(head);
        Assert.assertEquals(1, head.val);

        head = ListNodeUtil.createFromArrayWithoutHead(new int[]{4,2,1,3}, 4);
        head = l148.sortList2(head);
        Assert.assertEquals(1, head.val);

        head = ListNodeUtil.createFromArrayWithoutHead(new int[]{-1,5,3,4,0}, 5);
        head = l148.sortList2(head);
        Assert.assertEquals(-1, head.val);
    }
}
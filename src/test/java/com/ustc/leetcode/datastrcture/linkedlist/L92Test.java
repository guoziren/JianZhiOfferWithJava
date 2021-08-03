package com.ustc.leetcode.datastrcture.linkedlist;

import static org.junit.Assert.*;

import com.ustc.common.ListNode;
import com.ustc.common.ListNodeUtil;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class L92Test {

    @Test
    public void reverseBetween() {
        L92 l92 = new L92();
        ListNode head = ListNodeUtil.createFromArrayWithoutHead(new int[]{1,2,3,4,5},5);
        ListNode result = l92.reverseBetween(head, 1, 5);
        Assertions.assertThat(result.val).isEqualTo(5);
        Assertions.assertThat(result.next.val).isEqualTo(4);
        ListNodeUtil.printWithoutHead(result);

        head = ListNodeUtil.createFromArrayWithoutHead(new int[]{1,2,3,4,5},5);
        result = l92.reverseBetween(head, 2, 5);
        Assertions.assertThat(result.val).isEqualTo(1);
        Assertions.assertThat(result.next.val).isEqualTo(5);
        ListNodeUtil.printWithoutHead(result);

        head = ListNodeUtil.createFromArrayWithoutHead(new int[]{1,2,3,4,5},5);
        result = l92.reverseBetween(head, 3, 5);
        ListNodeUtil.printWithoutHead(result);

        head = ListNodeUtil.createFromArrayWithoutHead(new int[]{1,2,3,4,5},5);
        result = l92.reverseBetween(head, 4, 5);
        ListNodeUtil.printWithoutHead(result);

        head = ListNodeUtil.createFromArrayWithoutHead(new int[]{1,2,3,4,5},5);
        result = l92.reverseBetween(head, 5, 5);
        ListNodeUtil.printWithoutHead(result);

        head = ListNodeUtil.createFromArrayWithoutHead(new int[]{1,2,3,4,5},5);
        result = l92.reverseBetween(head, 3, 3);
        ListNodeUtil.printWithoutHead(result);

        head = ListNodeUtil.createFromArrayWithoutHead(new int[]{1,2,3},3);
        result = l92.reverseBetween(head, 2, 3);
        ListNodeUtil.printWithoutHead(result);

        head = ListNodeUtil.createFromArrayWithoutHead(new int[]{1,2,3},3);
        result = l92.reverseBetween(head, 1, 3);
        ListNodeUtil.printWithoutHead(result);

        head = ListNodeUtil.createFromArrayWithoutHead(new int[]{1,2},2);
        result = l92.reverseBetween(head, 1, 2);
        ListNodeUtil.printWithoutHead(result);

    }
}
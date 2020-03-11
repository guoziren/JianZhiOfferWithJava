package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.ListNode;
import com.ustc.common.TreeNode;

import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/description/
 * 109. 有序链表转换二叉搜索树
 */
public class L109 {
    /**
     * 时间上只击败了30.66%【第一种方法更有效】
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> array = new ArrayList<>();
        while (head != null){
            array.add(head.val);
            head = head.next;
        }
        return construct(array,0,array.size() - 1);

    }
    private TreeNode construct(ArrayList<Integer>  nums,int left, int right) {
        if(left > right){
            return null;
        }
        int mid = (left + right) >>> 1;
        TreeNode node = new TreeNode(nums.get(mid));
        TreeNode l = construct(nums,left,mid - 1);
        TreeNode r = construct(nums,mid + 1,right);
        node.left = l;
        node.right = r;
        return node;
    }
}

package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class L108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = construct(nums,0,nums.length - 1);
        return root;
    }

    private TreeNode construct(int[] nums, int left, int right) {
        if(left > right){
            return null;
        }
        int mid = (left + right) >>> 1;
        TreeNode node = new TreeNode(nums[mid]);
        TreeNode l = construct(nums,left,mid - 1);
        TreeNode r = construct(nums,mid + 1,right);
        node.left = l;
        node.right = r;
        return node;
    }
}

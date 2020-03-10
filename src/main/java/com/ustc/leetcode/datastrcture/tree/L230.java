package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

/**
 * 230. 二叉搜索树中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/description/
 */
public class L230 {
    int count = 1;
    int result = 0;
    //时间上只击败了75%
    public int kthSmallest(TreeNode root, int k) {
         traverse(root, k);
         return result;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null){
            return ;
        }
        kthSmallest(root.left,k);
        if (count == k){
            result = root.val;
        }
        count++;
        kthSmallest(root.right,k);

    }
}

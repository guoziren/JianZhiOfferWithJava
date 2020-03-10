package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

/**
 * 687. 最长同值路径
 * https://leetcode-cn.com/problems/longest-univalue-path/
 */
public class L687 {
    int result = Integer.MIN_VALUE;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null){
            return 0;
        }
         getCurNodeLongestPath(root);
         return result;
    }

    private ReturnData getCurNodeLongestPath(TreeNode root) {
        if (root == null){
            return new ReturnData(0,0);
        }
        ReturnData l = getCurNodeLongestPath(root.left);
        ReturnData r = getCurNodeLongestPath(root.right);
        int selfLongest = 0;
        int sideLongest = 0;
        if (root.left != null && root.val == root.left.val){
            selfLongest += l.sideLongset + 1;
            sideLongest = selfLongest;
        }
        if (root.right != null && root.val == root.right.val){
            selfLongest += r.sideLongset + 1;
           sideLongest  = sideLongest < r.sideLongset + 1 ? r.sideLongset + 1 : sideLongest;

        }
        result = selfLongest > result ? selfLongest : result;
        return new ReturnData(selfLongest,sideLongest);
    }
    class ReturnData{
        int selfLongest;//以当前结点为树根的最长路径，路径起点可以不是根
        int sideLongset;//以当前结点为树根的最长路径，路径起点是根

        public ReturnData(int selfLongest, int sideLongset) {
            this.selfLongest = selfLongest;
            this.sideLongset = sideLongset;
        }
    }
}

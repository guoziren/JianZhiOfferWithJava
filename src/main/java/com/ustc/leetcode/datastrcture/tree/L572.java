package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

/**
 * 572. 另一个树的子树
 * https://leetcode-cn.com/problems/subtree-of-another-tree/description/
 * 思路：递归遍历s，当s.val == t.val时，judge方法同时遍历2棵树，返回结果
 */
public class L572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null){
            return false;
        }
        if (s.val == t.val && judge(s,t)){
            return true;
        }

        boolean b1 = isSubtree(s.left,t);
        if (b1){
            return true;
        }
        boolean b2 = isSubtree(s.right,t);
        return b1 || b2;
    }


    private boolean judge(TreeNode s, TreeNode t) {
        if (s == null && t == null){
            return true;
        }
        if (s == null && t != null){
            return false;
        }
        if (s != null && t == null){
            return false;
        }
        if (s.val != t.val){
            return false;
        }
        boolean b1 = judge(s.left,t.left);
        boolean b2 = judge(s.right,t.right);
        return b1 && b2;
    }
}

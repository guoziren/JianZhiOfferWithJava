package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

import java.util.HashSet;

/**
 * 653. 两数之和 IV - 输入 BST
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 */
public class L653 {
    //法一：借助hashset 击败34.81%,时间复杂度O(n),空间复杂度：O(n)O(n)
//    HashSet<Integer> set;
//    public L653(){
//       set = new HashSet<>();
//    }
//    public boolean findTarget(TreeNode root, int k) {
//        if (root.left == null && root.right == null){
//            return false;
//        }
//
//        traverse(root);
//        for (Integer integer : set) {
//            if (set.contains(k - integer) && (k - integer) != integer){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private void traverse(TreeNode root) {
//        if (root == null){
//            return;
//        }
//        set.add(root.val);
//        traverse(root.left);
//        traverse(root.right);
//    }


    //法二：优化，不用一开始遍历一遍全部加入set
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet();
        return find(root, k, set);
    }

    public boolean find(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);

        return find(root.left, k, set) || find(root.right, k, set);
    }
}

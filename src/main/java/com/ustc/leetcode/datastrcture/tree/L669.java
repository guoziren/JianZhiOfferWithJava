package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

/**
 * 669. 修剪二叉搜索树
 * https://leetcode-cn.com/problems/trim-a-binary-search-tree/description/
 */
public class L669 {
    int l = 0;
    int r = 0;
    public TreeNode trimBST1(TreeNode root, int L, int R) {
        l = L;
        r = R;
       return trim(root,null);
    }

    private TreeNode trim(TreeNode node, TreeNode parent) {
        if (node == null){
            return null;
        }
        TreeNode result = node;
        if (node.val < l || node.val > r){
             result = process(node,parent);
        }

        if (result == null){
            return null;
        }

        parent = node;
        trim(result.left,parent);
        trim(result.right,parent);
        return result;
    }

    private TreeNode process(TreeNode node, TreeNode parent) {

        if (parent == null){
            //返回当前的树根
            //1.左右孩子都没
            if (node.left == null && node.right == null){
                return null;
            }
            //2.右有，左没 和 有左右
            if (node.right != null){
                return processRight(node.right,node);
            }
            //3.有左没右
//            if (node.left != null){
                return node.left;
//            }
        }else{
            //返回当前的树根

            //1.左右孩子都没
            if (node.left == null && node.right == null){
                if (node == parent.left){
                    parent.left = null;
                }else{
                    parent.right = null;
                }
                return null;
            }
            //2.右有，左没 和 有左右
            if (node.right != null && node.left != null){
                return process2(node,parent);
            }
            if (node.right != null && node.left == null){
                if (node == parent.left){
                    parent.left = node.right;
                }else{
                    parent.right = node.right;
                }
                return node.right;
            }

            //3.有左没右
            if (node == parent.left){
              parent.left = node.left;
            }else{
                parent.right = node.left;
            }
            return node.left;
        }
    }
    //删除node,node有右孩子,有parent
    private TreeNode process2(TreeNode node, TreeNode parent) {
        if (node.right.left == null){
            node.right.left = node.left;
            if (node == parent.left){
                parent.left = node.right.left;
            }else{
                parent.right = node.right.left;
            }
            return node.right.left;
        }
        TreeNode target = null;
        TreeNode targetFather = null;
        TreeNode p = node.right;
        while (p.left.left != null){
            p = p.left;
        }
        target = p.left;
        targetFather = p;
        target.left = node.left;
        targetFather.left = null;
        if (node == parent.left){
            parent.left = target;
        }else{
            parent.right = target;
        }
        return target;
    }

    private TreeNode processRight(TreeNode right, TreeNode parent) {
        if (right.left == null){
            right.left = parent.left;
            return right;
        }
        TreeNode p = right;
        TreeNode target = null;
        TreeNode targetFather = null;
        while (p.left.left != null){
            p = p.left;
        }
        targetFather = p;
        target = p.left;
        target.left = parent.left;
        target.right = right;
        targetFather.left = null;
        return target;
    }


    /**
     * 官方解法
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {return root;}
        if (root.val > R) {return trimBST(root.left, L, R);}
        if (root.val < L) {return trimBST(root.right, L, R);}

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
    //没有想到关键： 如果要删除的结点比l小，那他的左子树都比l小，不用考虑了，只用考虑右边

}

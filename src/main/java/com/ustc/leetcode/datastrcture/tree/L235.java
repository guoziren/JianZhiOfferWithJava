package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

import static java.util.Collections.copy;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 * 235. 二叉搜索树的最近公共祖先
 */
public class L235 {
    //击败了22 ~73%
    private LinkedList<TreeNode> pList = new LinkedList<>();
    private LinkedList<TreeNode> qList = new LinkedList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == root || q == root){
            return root;
        }
        if (p.val > root.val && q.val < root.val){
            return root;
        }
        if (p.val < root.val && q.val > root.val){
            return root;
        }
        ArrayList list = new ArrayList();
        int index = 0;
        if (p.val < root.val){
            process(root.left,list,index,p,q);
        }else{
            process(root.right,list,index,p,q);
        }
        int pSize = pList.size();
        int qSize = qList.size();
        int count = pSize - qSize;
        if (count > 0){
            while (count > 0){
                pList.pop();
                count--;
            }
        }else{
            while (count < 0){
                qList.pop();
                count++;
            }
        }



        while (pList.size() > 0 && pList.peek() != qList.peek()){
            pList.pop();
            qList.pop();
        }
        return pList.peek();
    }

    private void process(TreeNode root, ArrayList list, int index,TreeNode p,TreeNode q) {
        if (root == null){
            return;
        }
        if (index < 0 || index > list.size() - 1){
            list.add(root);
        }else{
            list.set(index,root);
        }
        if (root.val == p.val){
            copyList(list,pList,index);
        }
        if (root.val == q.val){
            copyList(list,qList,index);
        }
        process(root.left,list,index + 1,p,q);
        process(root.right,list,index + 1,p,q);
    }

    private void copyList(ArrayList<TreeNode> list, LinkedList<TreeNode> pList,int index) {
        for (int i = 0; i <= index; i++) {

            pList.push(list.get(i));
        }

    }
}

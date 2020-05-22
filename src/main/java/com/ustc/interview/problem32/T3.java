package com.ustc.interview.problem32;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 之字形打印二叉树
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 */
public class T3 {
    @Test
    public void test(){
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        levelOrder(head);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        List<Integer> list = new ArrayList<>();
        //先存右再存左，从左到右顺序输出一层结点
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        //先存左再存右，实现从右到左逆向输出一层结点
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        int curlevel = 1;
        stack1.push(root);
        int curLevelNodeNum = 1,nextLevelNodeNum = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            TreeNode p = null;
            if ((curlevel & 1) == 0){//偶数层
                p = stack2.pop();
            }else{
                p = stack1.pop();
            }
            list.add(p.val);
            curLevelNodeNum--;
            if ((curlevel & 1) == 0){//偶数层
                //偶数层从右到左输出，奇数层从左到右
                if (p.right != null){
                    nextLevelNodeNum++;
                    stack1.push(p.right);
                }
                if (p.left != null){
                    nextLevelNodeNum++;
                    stack1.push(p.left);
                }
            }else{
                //偶数层从右到左输出，奇数层从左到右
                if (p.left != null){
                    nextLevelNodeNum++;
                    stack2.push(p.left);
                }
                if (p.right != null){
                    nextLevelNodeNum++;
                    stack2.push(p.right);
                }
            }

            if (curLevelNodeNum == 0){
                result.add(list);
                list = new ArrayList<>();
                curlevel++;
                curLevelNodeNum = nextLevelNodeNum;
                nextLevelNodeNum = 0;
            }
        }
        return result;

    }
}

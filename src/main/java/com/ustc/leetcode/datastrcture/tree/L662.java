package com.ustc.leetcode.datastrcture.tree;

import com.sun.org.apache.xpath.internal.operations.String;
import com.ustc.common.TreeNode;
import com.ustc.zuoshen.day04.BinaryTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L662 {
    @Test
    public void test(){
        int pre[] = {1,3,5,3,2,9};
        int in[] = {5,3,3,1,2,9};
        int res = widthOfBinaryTree(new BinaryTree().construct(pre,in,6));
        System.out.println(res);
    }


    public int widthOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int curLevelNum = 1,nextLevNum = 0;
        int maxWidth = curLevelNum;
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            curLevelNum--;

            if (p.left != null){
                queue.offer(p.left);
                nextLevNum++;
                sb.append(1);
            }else{
                sb.append(0);
            }
            if (p.right != null){
                queue.offer(p.right);
                nextLevNum++;
                sb.append(1);
            }else {
                sb.append(0);
            }
            if (curLevelNum == 0){
                int length = getWidth(sb);
                maxWidth = Math.max(maxWidth,length);
                sb = new StringBuilder();
                curLevelNum = nextLevNum;
                nextLevNum = 0;
            }
        }
        return maxWidth;
    }

    private int getWidth(StringBuilder sb) {

        int beginIndex = sb.indexOf("1");
        if (beginIndex < 0 ){
            return 0;
        }
        int endIndex = sb.lastIndexOf("1");
        if (endIndex <= beginIndex){
            return 1;
        }

        return endIndex - beginIndex + 1;
    }
}

package com.ustc.interview.problem34;

import com.ustc.common.TreeNode;
import com.ustc.zuoshen.day04.BinaryTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JZ34 {
    //nowcoder
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null ){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        findPath(root,target,list,result);
        return result;
    }

    private void findPath(TreeNode root, int target, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {
        if (root == null){
            return;
        }
        list.add(root.val);
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        if (sum == target && root.left == null && root.right == null){
            ArrayList<Integer> r = new ArrayList<>();
            r.addAll(list);
            result.add(r);
        }
        findPath(root.left,target,list,result);
        findPath(root.right,target,list,result);
        list.remove(list.size() - 1);
    }
    //leetcode
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null ){
            return result;
        }
        List<Integer> list = new ArrayList<>();
        findPath(root,target,list,result,0);
        return result;
    }

    private void findPath(TreeNode root, int target, List<Integer> list, List<List<Integer>> result,int currentSum) {
        if (root == null){
            return;
        }
        list.add(root.val);
        currentSum += root.val;
        if (currentSum == target && root.left == null && root.right == null){
            ArrayList<Integer> r = new ArrayList<>();
            r.addAll(list);
            result.add(r);
        }
        findPath(root.left,target,list,result,currentSum);
        findPath(root.right,target,list,result,currentSum);
        list.remove(list.size() - 1);
    }
    @Test
    public void test(){
            BinaryTree tree = new BinaryTree();
        FindPath(tree.reconByPreString("10,5,4,#,#,7,#,#,12,#,#"),22);
    }
}

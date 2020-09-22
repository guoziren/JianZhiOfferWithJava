package com.ustc.interview.problem37;

import com.ustc.common.TreeNode;
import com.ustc.zuoshen.day04.BinaryTree;
import org.junit.Test;

import java.util.*;

public class InterviewProblem37 {
    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            sb.append("null,");
        }
        sb.append(root.val + ",");
        serialize(root.left);
        serialize(root.right);
        return sb.toString();
    }

    /**
     * 层序序列化
     * @param root
     * @return
     */
    public String serialize2(TreeNode root) {
        if (root == null){
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur == null){
                result.add("null");
            }else {
                result.add(String.valueOf(cur.val));
            }
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        while (result.get(result.size() - 1).equals("null")){
            result.remove(result.size() - 1);
        }

        return result.toString().replaceAll(" ","");
    }

    // Decodes your encoded data to tree.

    /**
     *
     * @param data "[1,2,3,null,null,4,5]"
     * @return
     */
    public TreeNode deserialize(String data) {
        String s = data.substring(1,data.length() - 1);
        if (data.length() <= 2){

            System.out.println("null");
            return null;
        }
        String[] strings = s.split(",");
        List<TreeNode> treeNodes = new ArrayList<>();
        for (String string : strings) {
            if (string.equals("null")){
                treeNodes.add(null);
            }else{
                treeNodes.add(new TreeNode(Integer.parseInt(string)));
            }
        }
        int size = treeNodes.size();
        for (int i = 0; i < size; i++) {
            if(treeNodes.get(i) == null){
                continue;
            }
            if (2 * i + 1 < size){
                treeNodes.get(i).left = treeNodes.get(2 * i + 1);
            }
            if (2 * i + 2 < size){
                treeNodes.get(i).right = treeNodes.get(2 * i + 2);
            }
        }

        return treeNodes.get(0);
    }


    @Test
    public void test(){
//        deserialize("[1,2,3,null,null,4,5]");
//       String res = serialize2( deserialize("[1,2,3,null,null,4,5]"));
//       String res = serialize2( deserialize("[2]"));
        BinaryTree tree = new BinaryTree();
       String res = tree.serialByPre( tree.reconByPreString("1，2，#，#，3，4，#，#，5，#，#，"));
        System.out.println(res);
        tree.reconByPreString(res);
//        List<String> ss = new ArrayList<>();
//        ss.add("1");
//        ss.add("2");
//        System.out.println(ss.toString());

    }


}

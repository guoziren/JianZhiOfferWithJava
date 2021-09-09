package com.ustc.common;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeUtil {
    /**
     * 力扣中是对给出的字符串按层序遍历构造的树，其中关键的一点是对于null节点，不再产生null字符串，仅非Null节点的孩子为null时才产生null字符串
     *
     * 序列号思路：
     *   层序遍历树，也就是BFS：
     *     对每层节点，
     *        null节点直接添加 "null,"到StringBuilder中;
     *        非Null节点添加对应的值，比如"5,"到StringBuilder中
     *   下一层数量的计算：一个非null节点，下一层数量加2， null节点则不加。
     * @param root 树根
     * @return 力扣中二叉树的序列化格式  比如 “[1,2,3,4,null,null,7,8]”
     */
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer( root);
        int curLevelNum = 1, nextLevelNum = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < curLevelNum; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    sb.append("null,");
                } else {
                    sb.append(poll.val);
                    sb.append(",");
                    queue.add(poll.left);
                    queue.add(poll.right);
                    nextLevelNum += 2;
                }

            }
            curLevelNum = nextLevelNum;
            nextLevelNum = 0;
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append("]");
        return sb.toString();
    }

    /**
     * 反序列化思路:
     * 1.根据[]中的节点值的字符串，构造TreeNode数组
     * 2.设置每个节点的孩子节点：
     *   2.1 循环每层节点
     *      null节点跳过
     *      非null节点，计算左右孩子节点的下标，其中要注意下标可能会越界，下一层节点数 + 2
     * @param data
     * @return
     */
    public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        if (data.equals("[]")) {
            return null;
        }
        String[] split = data.substring(1, data.length() - 1).split(",");
        int[] range = new int[]{0, 0};
        TreeNode[] treeNodes = new TreeNode[split.length];
        for (int i = 0; i < split.length; i++) {
            if (!split[i].equals("null")) {
                treeNodes[i] = new TreeNode(Integer.parseInt(split[i]));
            }
        }
        while (true) {
            // 下一层节点数量
            int nextLevelNodeNum = 0;
            for (int i = range[0]; i <= range[1]; i++) {
                String s = split[i];
                if (!s.equals("null")) {
                    // 设置孩子节点
                    TreeNode currentNode = treeNodes[i];
                    int leftChildIndex = range[1] + 1 + nextLevelNodeNum;
                    if (leftChildIndex < split.length) {
                        currentNode.left = treeNodes[leftChildIndex];
                    }
                    if (leftChildIndex + 1 < split.length) {
                        currentNode.right = treeNodes[leftChildIndex + 1];
                    }
                    nextLevelNodeNum += 2;
                }
            }
            // 下一层
            range = new int[]{range[1] + 1, range[1] + nextLevelNodeNum};
            if (range[1] + 1 >= split.length) {
                break;
            }
        }
        return treeNodes[0];
    }
}

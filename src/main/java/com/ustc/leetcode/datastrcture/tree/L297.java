package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

import java.util.*;

public class L297 {
    // Encodes a tree to a single string.
    // 超时 ,因为多余的null ， 下面的代码相当于是构造是一颗满二叉树
    public String serialize2(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curLevelNum = 1, nextLevelNum = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < curLevelNum; i++) {
                TreeNode poll = queue.poll();
                String val = poll == null ? "null," : poll.val + ",";
                sb.append(val);
                nextLevelNum += 2;
                if (poll == null) {
                    queue.add(null);
                    queue.add(null);
                } else {
                    queue.add(poll.left);
                    queue.add(poll.right);
                }
            }
            Iterator<TreeNode> iterator = queue.iterator();

            boolean isCurLevelAllNull = true;
            while (iterator.hasNext()) {
                TreeNode next = iterator.next();
                if (next != null) {
                    isCurLevelAllNull = false;
                }
            }
            if (isCurLevelAllNull) {
                break;
            }
            curLevelNum = nextLevelNum;
            nextLevelNum = 0;
        }
        sb.substring(0, sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Encodes a tree to a single string.
    // 方法三：超出内存限制，因为多余的null
//    public String serialize3(TreeNode root) {
//        if (root == null) {
//            return "[]";
//        }
//        StringBuilder sb = new StringBuilder();
//        sb.append("[");
//        Queue<ANode> queue = new LinkedList<>();
//        queue.offer(new ANode(1, root));
//        int curLevelNum = 1, nextLevelNum = 0;
//        int currentPosition = 1;
//        while (!queue.isEmpty()) {
//            for (int i = 0; i < curLevelNum; i++) {
//                ANode poll = queue.poll();
//                if (poll.position == currentPosition) {
//                    currentPosition++;
//                } else {
//                    for (int j = 0; j < poll.position - currentPosition; j++) {
//                        sb.append("null,");
//                    }
//                    currentPosition = poll.position + 1;
//                }
//                sb.append(poll.node.val + ",");
//                if (poll.node.left != null) {
//                    queue.add(new ANode(2 * poll.position, poll.node.left));
//                    nextLevelNum++;
//                }
//                if (poll.node.right != null) {
//                    queue.add(new ANode(2 * poll.position + 1, poll.node.right));
//                    nextLevelNum++;
//                }
//            }
//            curLevelNum = nextLevelNum;
//            nextLevelNum = 0;
//        }
//        sb.delete(sb.length() - 1, sb.length());
//        sb.append("]");
//        return sb.toString();
//    }
//    class ANode{
//        int position;
//        TreeNode node;
//
//        public ANode(int position, TreeNode node) {
//            this.position = position;
//            this.node = node;
//        }
//    }

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
    public String serialize(TreeNode root) {
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

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
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

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        if (data.equals("[]")) {
            return null;
        }
        String[] split = data.substring(1, data.length() - 1).split(",");
        List<String> treeNodeString = new ArrayList<>(split.length + 1);
        treeNodeString.add(null); // 哨兵
        for (String s : split) {
            treeNodeString.add(s);
        }
        return dfs(treeNodeString, 1);

    }

    private TreeNode dfs(List<String> treeNodeString, int i) {
        if (i >= treeNodeString.size()) {
            return null;
        }
        String s = treeNodeString.get(i);
        if (s.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        TreeNode left = dfs(treeNodeString, i * 2);
        TreeNode right = dfs(treeNodeString, i * 2 + 1);
        root.left = left;
        root.right = right;
        return root;
    }
}

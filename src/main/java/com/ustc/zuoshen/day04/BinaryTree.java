package com.ustc.zuoshen.day04;

import com.ustc.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的构造，以及递归和非递归遍历的实现
 * 二叉树的序列化和反序列化
 * 平衡，搜索、完全二叉树的判断
 * 完全二叉树结点个数的计算
 * 寻找给定结点的后继节点
 */
public class BinaryTree {

    //非递归先序遍历
    public void preOrderUnCur(TreeNode root){
        if (root == null){
            System.out.println("这是个空树");
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        System.out.println("");
    }


    /**
     * 非递归中序遍历
     * 当栈为空 && 当前结点为时 才结束循环，否则循环执行下面2句
     * 当前结点为空，从栈中弹出一个变成当前结点打印，并指向右孩子；
     * 当前结点不空，当前结点入栈，当前结点并指向左孩子‘
     * @param root 树根
     */
    public void inOrderUnCur(TreeNode root){
        if (root == null){
            System.out.println("这是个空树");
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else{
                p = stack.pop();
                System.out.print(p.val + " ");
                p = p.right;
            }
        }
        System.out.println("");
    }
    //非递归后序遍历(实现输出左右中的顺序)
    public void postOrderUnCur(TreeNode root){
        if (root == null){
            System.out.println("这是个空树");
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> helpStack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            helpStack.push(node);
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }

        }
        while (!helpStack.isEmpty()){
            TreeNode node = helpStack.pop();
            System.out.print(node.val + " ");
        }
        System.out.println();
    }


    /**
     * 根据先序和中序遍历构造一颗二叉树
     * @param preorder
     * @param inorder
     * @param length
     * @return
     */
    public TreeNode construct(int[] preorder, int[] inorder, int length){
        if (preorder == null || inorder == null || length <= 0){
            return null;
        }

        return constructCore(preorder,inorder,0, length - 1,0,length - 1);
    }
    public TreeNode constructCore(int[] preorder, int[] inorder, int startPreorder, int endPreorder, int startInorder, int endInorder){
        int rootValue = preorder[startPreorder];
        TreeNode root = new TreeNode(rootValue);
        root.left = root.right = null;

        //在中序遍历序列中找到根节点的位置
        int rootInorder = startInorder;
        while (rootInorder <= endInorder && inorder[rootInorder] != rootValue){
            rootInorder++;
        }

        int leftLength = rootInorder -startInorder;
        int leftPreorderEnd = startPreorder + leftLength;
        if (leftLength > 0){
            //构建左子树
            root.left = constructCore(preorder,inorder,startPreorder + 1,leftPreorderEnd,
                    startInorder,rootInorder - 1);
        }
        if (leftLength < endPreorder - startPreorder){
            //构建右子树
            root.right = constructCore(preorder,inorder,leftPreorderEnd + 1,endPreorder,
                    rootInorder + 1,endInorder);
        }
        return root;

    }

    /**
     * 递归中序遍历
     * @param root
     */
    public void inTraverse(TreeNode root){
        if (root == null){
            return;
        }
        inTraverse(root.left);
        System.out.print(root.val + " ");
        inTraverse(root.right);
    }
    /**
     * 递归先序遍历
     * @param root
     */
    public void preTraverse(TreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.val + " ");
        preTraverse(root.left);
        preTraverse(root.right);
    }
    /**
     * 递归后序遍历
     * @param root
     */
    public void postTraverse(TreeNode root){
        if (root == null){
            return;
        }
        preTraverse(root.left);
        preTraverse(root.right);
        System.out.print(root.val + " ");
    }
    /**
     * 判断是否平衡二叉树(AVL)
     * @param root
     * @return
     */
    public boolean isAVLBinaryTree(TreeNode root) {
        return process(root).isAvl;
    }
    public AVLReturnData process(TreeNode root){
        if (root == null){
            return new AVLReturnData(true,0);
        }
        AVLReturnData l = process(root.left);
        AVLReturnData r = process(root.right);
        if (!l.isAvl ){
            return new AVLReturnData(false,0);
        }
        if (!r.isAvl){
            return new AVLReturnData(false,0);
        }
        if (Math.abs(l.height - r.height) > 1){
            return new AVLReturnData(false,0);
        }
        return new AVLReturnData(true,Math.max(l.height,r.height) + 1);
    }
    class AVLReturnData{
        boolean isAvl;
        int height;

        public AVLReturnData(boolean isAvl, int height) {
            this.isAvl = isAvl;
            this.height = height;
        }
    }

    /**
     * 判断是否为搜索/查找/排序二叉树
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * @param root
     * @return
     */
    public boolean isSearchBinaryTree(TreeNode root) {
        if (root == null){
            System.out.println("这是个空树");
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        Integer pre = null;
        while (!stack.isEmpty() || p != null){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else{
                p = stack.pop();
                if (pre != null && p.val < pre){
                    return false;
                }
                pre = new Integer(p.val);
              //  System.out.print(p.val + " ");
                p = p.right;
            }
        }
        return true;
      //  System.out.println("");
    }
    /**
     * 判断是否为完全二叉树
     * @param root
     * @return
     */
    public boolean isFullBinaryTree(TreeNode root){
        if (root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode leftChild = null;
        TreeNode rightChild = null;
        boolean leaf = false;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            rightChild = node.right;
            leftChild = node.left;
            if (leftChild == null && rightChild != null){
                return false;
            }
            if (leaf && (leftChild != null || rightChild != null)){
                return false;
            }

            if (leftChild != null){
                queue.add(leftChild);
            }
            if (rightChild != null){
                queue.add(rightChild);
            }
            if (leftChild == null || rightChild == null){
                leaf = true;
            }
        }
        return true;
    }

    /**
     * 要求时间复杂度低于O(N)
     * 思路：
     * @param root 完全二叉树的树根
     * @return 该树的节点个数
     */
    public int nodeNum(TreeNode root){
        if (root == null){
            return 0;
        }
        return bs(root,getFBTHeight(root));
    }
    /*以root为根，高度为height的完全二叉树的结点数*/
    private int bs(TreeNode root, int height) {
        if (root == null){
            return 0;
        }
        if (getFBTHeight(root.right) == height - 1){
            //左子树满
            int num1 = 1 << (height - 1);
            int num2 = bs(root.right,height - 1);
//            return 1 << (height - 1) + bs(root.rightChild,height - 1);
            return num1 + num2;
        }else{
            //右子树满
            int num3 = 1 << (height - 2);
            int num4 = bs(root.left,height - 1);
//            return 1 << (height - 2) + bs(root.leftChild,height - 1);
            return num3 + num4;
        }
    }

    /**
     *  求完全二叉树的高度,单独不空的根节点高度为1
     *  时间复杂度O(logn) * O(logn * @param root 树根
     * @return 完全二叉树的高度
     */
    private int getFBTHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        int h = 1;
        while (root.left != null){
            root = root.left;
            h++;
        }
        return h;
    }
    //二叉树的序列化【先序】
    public String serialByPre(TreeNode root){
        if (root == null){
            return "#!";
        }
        String res = root.val + "!";
        res+= serialByPre(root.left);
        res+= serialByPre(root.right);
        return res;
    }
    //二叉树的反序列化【先序】
    public TreeNode reconByPreString(String preStr){
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    private TreeNode reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }
        //序列化是中左右，反序列化也是
        TreeNode node = new TreeNode(Integer.valueOf(value));
        node.left = reconPreOrder(queue);
        node.right = reconPreOrder(queue);
        return node;
    }
    //在二叉树中找到一个节点的后继节点[中序遍历的后一个结点],用最经济的方式，避免遍历整棵树
    public TreeNode getSucessorNode(TreeNode node){
        if (node == null){
            return null;
        }
        //是否有右子树，有的话，就是右子树最左节点
       if (node.right != null){
            return findMostLeft(node.right);
       }else {
           TreeNode parent = node.parent;
           while (parent != null && node != parent.left){
               node = node.parent;
               parent = parent.parent;
           }
           return parent;
       }
        //没有右子树，则向上找
    }
    private TreeNode findMostLeft(TreeNode node){
        if (node == null){
            return null;
        }
        while (node.left != null){
            node = node.left;
        }
        return node;
    }
}

package com.ustc.zuoshen.day04;

import com.ustc.common.BinaryTreeNode;

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
    public void preOrderUnCur(BinaryTreeNode root){
        if (root == null){
            System.out.println("这是个空树");
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            BinaryTreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.rightChild != null){
                stack.push(node.rightChild);
            }
            if (node.leftChild != null){
                stack.push(node.leftChild);
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
    public void inOrderUnCur(BinaryTreeNode root){
        if (root == null){
            System.out.println("这是个空树");
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode p = root;
        while (!stack.isEmpty() || p != null){
            if(p != null){
                stack.push(p);
                p = p.leftChild;
            }else{
                p = stack.pop();
                System.out.print(p.val + " ");
                p = p.rightChild;
            }
        }
        System.out.println("");
    }
    //非递归后序遍历(实现输出左右中的顺序)
    public void postOrderUnCur(BinaryTreeNode root){
        if (root == null){
            System.out.println("这是个空树");
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        Stack<BinaryTreeNode> helpStack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            BinaryTreeNode node = stack.pop();
            helpStack.push(node);
            if (node.leftChild != null){
                stack.push(node.leftChild);
            }
            if (node.rightChild != null){
                stack.push(node.rightChild);
            }

        }
        while (!helpStack.isEmpty()){
            BinaryTreeNode node = helpStack.pop();
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
    public  BinaryTreeNode construct(int[] preorder, int[] inorder, int length){
        if (preorder == null || inorder == null || length <= 0){
            return null;
        }

        return constructCore(preorder,inorder,0, length - 1,0,length - 1);
    }
    public  BinaryTreeNode constructCore(int[] preorder, int[] inorder,int startPreorder, int endPreorder, int startInorder, int endInorder){
        int rootValue = preorder[startPreorder];
        BinaryTreeNode root = new BinaryTreeNode(rootValue);
        root.leftChild = root.rightChild = null;

        //在中序遍历序列中找到根节点的位置
        int rootInorder = startInorder;
        while (rootInorder <= endInorder && inorder[rootInorder] != rootValue){
            rootInorder++;
        }

        int leftLength = rootInorder -startInorder;
        int leftPreorderEnd = startPreorder + leftLength;
        if (leftLength > 0){
            //构建左子树
            root.leftChild = constructCore(preorder,inorder,startPreorder + 1,leftPreorderEnd,
                    startInorder,rootInorder - 1);
        }
        if (leftLength < endPreorder - startPreorder){
            //构建右子树
            root.rightChild = constructCore(preorder,inorder,leftPreorderEnd + 1,endPreorder,
                    rootInorder + 1,endInorder);
        }
        return root;

    }

    /**
     * 递归中序遍历
     * @param root
     */
    public void inTraverse(BinaryTreeNode root){
        if (root == null){
            return;
        }
        inTraverse(root.leftChild);
        System.out.print(root.val + " ");
        inTraverse(root.rightChild);
    }
    /**
     * 递归先序遍历
     * @param root
     */
    public void preTraverse(BinaryTreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.val + " ");
        preTraverse(root.leftChild);
        preTraverse(root.rightChild);
    }
    /**
     * 递归后序遍历
     * @param root
     */
    public void postTraverse(BinaryTreeNode root){
        if (root == null){
            return;
        }
        preTraverse(root.leftChild);
        preTraverse(root.rightChild);
        System.out.print(root.val + " ");
    }
    /**
     * 判断是否平衡二叉树(AVL)
     * @param root
     * @return
     */
    public boolean isAVLBinaryTree(BinaryTreeNode root) {
        return process(root).isAvl;
    }
    public AVLReturnData process(BinaryTreeNode root){
        if (root == null){
            return new AVLReturnData(true,0);
        }
        AVLReturnData l = process(root.leftChild);
        AVLReturnData r = process(root.rightChild);
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
     * @param root
     * @return
     */
    public boolean isSearchBinaryTree(BinaryTreeNode root) {
        if (root == null){
            System.out.println("这是个空树");
            return true;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode p = root;
        int pre = Integer.MIN_VALUE;
        while (!stack.isEmpty() || p != null){
            if(p != null){
                stack.push(p);
                p = p.leftChild;
            }else{
                p = stack.pop();
                if (p.val < pre){
                    return false;
                }
                pre = p.val;
              //  System.out.print(p.val + " ");
                p = p.rightChild;
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
    public boolean isFullBinaryTree(BinaryTreeNode root){
        if (root == null){
            return true;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryTreeNode leftChild = null;
        BinaryTreeNode rightChild = null;
        boolean leaf = false;
        while (!queue.isEmpty()){
            BinaryTreeNode node = queue.poll();
            rightChild = node.rightChild;
            leftChild = node.leftChild;
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
    public int nodeNum(BinaryTreeNode root){
        if (root == null){
            return 0;
        }
        return bs(root,getFBTHeight(root));
    }
    /*以root为根，高度为height的完全二叉树的结点数*/
    private int bs(BinaryTreeNode root, int height) {
        if (root == null){
            return 0;
        }
        if (getFBTHeight(root.rightChild) == height - 1){
            //左子树满
            int num1 = 1 << (height - 1);
            int num2 = bs(root.rightChild,height - 1);
//            return 1 << (height - 1) + bs(root.rightChild,height - 1);
            return num1 + num2;
        }else{
            //右子树满
            int num3 = 1 << (height - 2);
            int num4 = bs(root.leftChild,height - 1);
//            return 1 << (height - 2) + bs(root.leftChild,height - 1);
            return num3 + num4;
        }
    }

    /**
     *  求完全二叉树的高度,单独不空的根节点高度为1
     *  时间复杂度O(logn) * O(logn * @param root 树根
     * @return 完全二叉树的高度
     */
    private int getFBTHeight(BinaryTreeNode root){
        if (root == null){
            return 0;
        }
        int h = 1;
        while (root.leftChild != null){
            root = root.leftChild;
            h++;
        }
        return h;
    }
    //二叉树的序列化【先序】
    public String serialByPre(BinaryTreeNode root){
        if (root == null){
            return "#!";
        }
        String res = root.val + "!";
        res+= serialByPre(root.leftChild);
        res+= serialByPre(root.rightChild);
        return res;
    }
    //二叉树的反序列化【先序】
    public BinaryTreeNode reconByPreString(String preStr){
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    private BinaryTreeNode reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }
        //序列化是中左右，反序列化也是
        BinaryTreeNode node = new BinaryTreeNode(Integer.valueOf(value));
        node.leftChild = reconPreOrder(queue);
        node.rightChild = reconPreOrder(queue);
        return node;
    }
    //在二叉树中找到一个节点的后继节点[中序遍历的后一个结点],用最经济的方式，避免遍历整棵树
    public BinaryTreeNode getSucessorNode(BinaryTreeNode node){
        if (node == null){
            return null;
        }
        //是否有右子树，有的话，就是右子树最左节点
       if (node.rightChild != null){
            return findMostLeft(node.rightChild);
       }else {
           BinaryTreeNode parent = node.parent;
           while (parent != null && node != parent.leftChild){
               node = node.parent;
               parent = parent.parent;
           }
           return parent;
       }
        //没有右子树，则向上找
    }
    private BinaryTreeNode findMostLeft(BinaryTreeNode node){
        if (node == null){
            return null;
        }
        while (node.leftChild != null){
            node = node.leftChild;
        }
        return node;
    }
}

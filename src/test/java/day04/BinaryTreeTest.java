package day04;


import com.ustc.common.TreeNode;
import com.ustc.zuoshen.day04.BinaryTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTreeTest {
    @Test
    public void test1(){
        int preorder[] = {1,2,4,7,3,5,6,8};
        int inorder[] = {4,7,2,1,5,3,8,6};
        int len = preorder.length;
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.construct(preorder,inorder,len);
        System.out.println("递归:");
        tree.preTraverse(root);
        System.out.println("");
        tree.inTraverse(root);
        System.out.println("");
        System.out.println("非递归:");
        tree.preOrderUnCur(root);
        tree.inOrderUnCur(root);
        tree.postOrderUnCur(root);
    }
    //test2()~test4()测试求完全二叉树的结点树
    @Test
    public void test2(){
        int preorder[] = {0,1,3,7,8,4,9,10,2,5,11,6};
        int inorder[] = {7,3,8,1,9,4,10,0,11,5,2,6};
        int len = preorder.length;
        System.out.println(len);
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.construct(preorder,inorder,len);
        int num = tree.nodeNum(root);
        System.out.println(num);
    }
    @Test
    public void test3(){
        int preorder[] = {0,1,3,7,4,2,5,6};
        int inorder[] = {7,3,1,4,0,5,2,6};
        int len = preorder.length;
        System.out.println(len);
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.construct(preorder,inorder,len);
        int num = tree.nodeNum(root);
        System.out.println(num);
    }
    @Test
    public void test4(){
        int preorder[] = {0,1};
        int inorder[] = {1,0};
        int len = preorder.length;
        System.out.println(len);
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.construct(preorder,inorder,len);
        int num = tree.nodeNum(root);
        System.out.println(num);
    }
    //测试是否为搜索二叉树
    @Test
    public void test5(){
        int preorder[] = {0,1,3,7,4,2,5,6};
        int inorder[] = {7,3,1,4,0,5,2,6};
        int len = preorder.length;
        System.out.println(len);
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.construct(preorder,inorder,len);
        boolean isSearchBinaryTree = tree.isSearchBinaryTree(root);
        tree.inTraverse(root);
        System.out.println("");
        System.out.println("isSearchBinaryTree=" + isSearchBinaryTree);
    }
    @Test
    public void test6(){
        int preorder[] = {5,2,1,3,6,5,7};
        int inorder[] = {1,2,3,5,5,6,7};
        int len = preorder.length;
        System.out.println(len);
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.construct(preorder,inorder,len);
        boolean isSearchBinaryTree = tree.isSearchBinaryTree(root);
        tree.inTraverse(root);
        System.out.println("");
        System.out.println("isSearchBinaryTree=" + isSearchBinaryTree);

    }
    @Test
    public void test7(){


    }
}

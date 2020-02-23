package com.ustc.interview.problem7;

public class InterviewProblem7 {
    public static void main(String[] args) {
        int preorder[] = {1,2,4,7,3,5,6,8};
        int inorder[] = {4,7,2,1,5,3,8,6};
        int len = preorder.length;
        BinaryTreeNode root = construct(preorder,inorder,len);
        preTraverse(root);
        System.out.println("");
        inTraverse(root);

    }
    public static BinaryTreeNode construct(int[] preorder,int[] inorder,int length){
        if (preorder == null || inorder == null || length <= 0){
            return null;
        }

        return constructCore(preorder,inorder,0, length - 1,0,length - 1);
    }
    public static BinaryTreeNode constructCore(int[] preorder,int[] inorder,
                                          int startPreorder,int endPreorder,int startInorder,int endInorder){
       int rootValue = preorder[startPreorder];
       BinaryTreeNode root = new BinaryTreeNode(rootValue);
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
    public static void inTraverse(BinaryTreeNode root){
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
    public static void preTraverse(BinaryTreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.val + " ");
        preTraverse(root.left);
        preTraverse(root.right);
    }
}

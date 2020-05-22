package com.ustc.interview.problem36;

public class InterviewProblem {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return null;
        }
        TreeNode lastNode = convert(pRootOfTree);
        TreeNode head = lastNode;
        while (head.left != null){
            head = head.left;
        }
        return head;
    }

    private TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return null;
        }

        //转换左子树，返回中序遍历的最后一个结点
        TreeNode lastNode = convert(pRootOfTree.left);

        //根节点的左孩子指向左子树中序遍历的最后一个结点(转换双链表)
        if (lastNode != null){
            lastNode.right = pRootOfTree;
            pRootOfTree.left = lastNode;
        }
        //把先右子树的最小结点存下来
        TreeNode successorNode = findSuccessorNode(pRootOfTree.right);
        //转换右子树
        TreeNode lastNode2 = convert(pRootOfTree.right);

        //根结点的右孩子指向右子树的最小结点(转换双链表)
        pRootOfTree.right = successorNode;
        if (successorNode != null){
            successorNode.left = pRootOfTree;
        }
        //右子树为空，根节点就是中序遍历的最后1个结点,返回它
        if (lastNode2 == null){
            return pRootOfTree;
        }
        //返回以pRootOfTree为根结点的中序遍历的最后一个结点
        return lastNode2;
    }

    private TreeNode findSuccessorNode(TreeNode right) {
        if (right == null){
            return null;
        }
        TreeNode parent = right;
        TreeNode p = right;
        while (p != null){
            parent = p;
            p = p.left;
        }
        return parent;
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
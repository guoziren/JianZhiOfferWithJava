package com.ustc.interview.problem54;

import com.ustc.common.TreeNode;

/**
 * 面试题54：二叉搜索树的第k大结点
 * https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a?tpId=13&tqId=11215&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=4
 */
public class InterviewProblem54 {
    int count = 0;
    TreeNode KthNode(TreeNode pRoot, int k){
        TreeNode result = null;
        if (pRoot == null || k == 0){
            return null;
        }
        result =  KthNode(pRoot.left,k);
        count++;
        if (count == k){
            result = pRoot;
        }
        if (result == null){
            result = KthNode(pRoot.right,k);
        }
        return result;
    }
}

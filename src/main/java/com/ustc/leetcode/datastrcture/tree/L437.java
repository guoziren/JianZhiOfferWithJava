package com.ustc.leetcode.datastrcture.tree;

import com.ustc.common.TreeNode;

/**
 * 437. 路径总和 III
 * https://leetcode-cn.com/problems/path-sum-iii/submissions/
 * 思路:
 * 遍历每个节点。 关键点：递归
 * 计算以当前节点为路径终点的所有路径和。 关键点：用一个数组保存从根节点到当前节点路径
 */
public class L437 {
    public int pathSum(TreeNode root, int sum) {
        return pathSum(root, sum, new int[1000], 0);
    }

    public int pathSum(TreeNode root, int sum, int[] array/*保存路径*/, int p/*指向路径终点*/) {
        if (root == null) {
            return 0;
        }
        int tmp = root.val;
        int n = root.val == sum ? 1 : 0;
        for (int i = p - 1; i >= 0; i--) {
            tmp += array[i];
            if (tmp == sum) {
                n++;
            }
        }
        array[p] = root.val;
        int n1 = pathSum(root.left, sum, array, p + 1);
        int n2 = pathSum(root.right, sum, array, p + 1);
        return n + n1 + n2;
    }

}

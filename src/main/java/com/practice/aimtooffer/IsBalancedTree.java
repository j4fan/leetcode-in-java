package com.practice.aimtooffer;

/**
 * task5判断一颗二叉树是否为平衡树
 */
public class IsBalancedTree {

    public boolean isBalancedSolution(TreeNode root) {
        if (root == null) return true;
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode node) {
        if (node == null) return 0;
        if (getDepth(node.left) == -1 || getDepth(node.right) == -1) return -1;
        return Math.abs(getDepth(node.left) - getDepth(node.right)) > 1 ? -1 : Math.max(getDepth(node.left), getDepth(node.right));
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

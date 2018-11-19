package com.practice.aimtooffer;

public class IsBalancedTree {

    public boolean isBalancedSolution(TreeNode root) {
        if (root == null) {
            return false;
        } else if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        } else {
            return isBalancedSolution(root.left) && isBalancedSolution(root.right);
        }
    }


    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int left = height(node.left);
            int right = height(node.right);
            return left > right ? left + 1 : right + 1;
        }
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

package com.practice.aimtooffer;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmetrical {
    static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        } else {
            if (pRoot.left == null && pRoot.right != null) return false;
            if (pRoot.left != null && pRoot.right == null) return false;
            if (pRoot.left == null && pRoot.right == null) return true;
            return isMirrorNode(pRoot.left, pRoot.right);
        }
    }

    static boolean isMirrorNode(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left.val != right.val) return false;
        return isMirrorNode(left.left, right.right) && isMirrorNode(left.right, right.left);
    }

    public static class TreeNode {

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(8);
        TreeNode left = new TreeNode(6);
        TreeNode right = new TreeNode(6);
        head.left = left;
        head.right = right;
        TreeNode leftleft = new TreeNode(5);
        TreeNode leftright = new TreeNode(7);
        TreeNode rightleft = new TreeNode(7);
        TreeNode rightright = new TreeNode(5);
        left.left = leftleft;
        left.right = leftright;
        right.left = rightleft;
        right.right = rightright;

        System.out.println(IsSymmetrical.isSymmetrical(head));
    }
}

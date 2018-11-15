package com.practice.aimtooffer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class CheckRelationBetweenTrees {

    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        if (treeEquals(root1, root2)) {
            return true;
        } else if ((root1.left != null && hasSubtree(root1.left, root2)) || (root1.right != null && hasSubtree(root1.right, root2))) {
            return true;
        }
        return false;
    }

    private static boolean treeEquals(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 != null && root1.val == root2.val) {
            return treeEquals(root1.left, root2.left) && treeEquals(root1.right, root2.right);
        }
        return false;
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode leftOne = new TreeNode(4);
        TreeNode leftTwo = new TreeNode(5);
        root1.left = left;
        root1.right = right;
        left.left = leftOne;
        left.right = leftTwo;

        TreeNode root2 = new TreeNode(1);
        TreeNode root2Left = new TreeNode(4);
        TreeNode root2Right = new TreeNode(5);
        root2.left = root2Left;
        root2.right = root2Right;

        System.out.println(hasSubtree(root1,root2));
    }
}

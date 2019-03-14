package com.practice.aimtooffer;

/**
 * task1:输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class CheckRelationBetweenTrees {

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        if (doesTree1HavaTree2(root1, root2)) return true;
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private static boolean doesTree1HavaTree2(TreeNode node1, TreeNode node2) {
        if(node2==null) return true;
        if(node1==null||node1.val!=node2.val) return false;
        return doesTree1HavaTree2(node1.left, node2.left) && doesTree1HavaTree2(node1.right, node2.right);
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
        TreeNode root = new TreeNode(8);
        TreeNode rootLeft = new TreeNode(8);
        TreeNode rootRight = new TreeNode(7);
        root.left = rootLeft;
        root.right = rootRight;
        TreeNode leftLeft = new TreeNode(9);
        TreeNode leftRight = new TreeNode(2);
        rootLeft.left = leftLeft;
        rootLeft.right = leftRight;
        TreeNode rightLeft = new TreeNode(4);
        TreeNode rightRight = new TreeNode(7);
        rootRight.left = rightLeft;
        rootRight.right = rightRight;

        TreeNode testRoot = new TreeNode(8);
        TreeNode testLeft = new TreeNode(8);
        TreeNode testRight = new TreeNode(7);
        testRoot.left = testLeft;
        testRoot.right = testRight;
        System.out.println(HasSubtree(root, testRoot));
    }

}

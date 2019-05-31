package com.practice.aimtooffer;

/**
 * task20序列化二叉树
 */
public class SerializeBinaryTree {
    private static int flag = -1;

    public static String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    public static TreeNode deserialize(String str) {
        flag++;
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] strs = str.split(",");
        if (!strs[flag].equals("#")) {
            TreeNode node = new TreeNode(Integer.parseInt(strs[flag]));
            node.left = deserialize(str);
            node.right = deserialize(str);
            return node;
        }
        return null;
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
        TreeNode leftleft = new TreeNode(5);
        TreeNode leftright = new TreeNode(7);
        TreeNode rightleft = new TreeNode(7);
        TreeNode rightright = new TreeNode(5);
        left.left = leftleft;
        left.right = leftright;
        right.left = rightleft;
        right.right = rightright;

        System.out.println(serialize(head));

        TreeNode node = deserialize(serialize(head));
        System.out.println("test");
    }
}

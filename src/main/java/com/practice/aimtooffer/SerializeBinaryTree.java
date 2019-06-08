package com.practice.aimtooffer;

/**
 * task22序列化二叉树
 * 思路:前序遍历
 */
public class SerializeBinaryTree {
    private static int flag = -1;
    private static final char EMPTY_MARK = '#';

    public static String serialize(TreeNode root) {
        if(root==null){
            return EMPTY_MARK+"";
        }
        StringBuffer sb = new StringBuffer();
        sb.append(root.val);
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }


    public static TreeNode deserialize(String str) {
        flag++;
        if(flag>=str.length()) return null;
        TreeNode node = null;
        if(EMPTY_MARK!=str.charAt(flag)){
            node = new TreeNode(Integer.parseInt(str.substring(flag,flag+1)));
            node.left = deserialize(str);
            node.right = deserialize(str);
        }
        return node;
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

        System.out.println(serialize(head));

        TreeNode node = deserialize(serialize(head));
        System.out.println(serialize(node));
    }
}

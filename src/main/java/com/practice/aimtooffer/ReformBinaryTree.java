package com.practice.aimtooffer;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回
 **/
public class ReformBinaryTree {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        int count = 0;
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                count = i;
                break;
            }
        }

        int[] leftFront = Arrays.copyOfRange(pre, 1, count + 1);
        int[] leftMiddle = Arrays.copyOfRange(in, 0, count);
        int[] rightFront = Arrays.copyOfRange(pre, count + 1, pre.length);
        int[] rightMiddle = Arrays.copyOfRange(in, count + 1, pre.length);

        node.left = reConstructBinaryTree(leftFront, leftMiddle);
        node.right = reConstructBinaryTree(rightFront, rightMiddle);

        return node;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] b = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = new ReformBinaryTree().reConstructBinaryTree(a, b);
        new ReformBinaryTree().frontPrint(treeNode);
    }

    private void frontPrint(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.println(treeNode.val);
            frontPrint(treeNode.left);
            frontPrint(treeNode.right);
        }
    }
}

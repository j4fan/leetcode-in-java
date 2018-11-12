package com.practice.aimtooffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintBinaryTree {

    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> printList = new ArrayList<>();
        Queue<TreeNode> nodeArrayList = new LinkedBlockingQueue<>();
        if (root != null) {
            nodeArrayList.offer(root);
        }
        while (!nodeArrayList.isEmpty()) {
            TreeNode node = nodeArrayList.poll();
            printList.add(node.val);
            if (node.left != null) {
                nodeArrayList.offer(node.left);
            }
            if (node.right != null) {
                nodeArrayList.offer(node.right);
            }
        }
        return printList;
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
        //构造二叉树
        TreeNode root = new TreeNode(5);
        TreeNode secondLeft = new TreeNode(3);
        TreeNode secondRight = new TreeNode(4);
        TreeNode thirdLeft = new TreeNode(1);
        root.left = secondLeft;
        root.right = secondRight;
        secondLeft.left = thirdLeft;
        List list = printFromTopToBottom(root);
        list.forEach(i->{
            System.out.println(i);
        });

    }
}

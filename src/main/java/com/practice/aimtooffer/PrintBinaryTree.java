package com.practice.aimtooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * task12从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintBinaryTree {

    public static ArrayList<ArrayList<Integer>> printFromTopToBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int start = 0;
        int end = 1;
        ArrayList<Integer> rowList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            rowList.add(node.val);
            start++;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (start == end) {
                start = 0;
                end = queue.size();
                resultList.add(rowList);
                rowList = new ArrayList<>();
            }
        }
        return resultList;
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
        List<ArrayList<Integer>> list = printFromTopToBottom(root);
        System.out.println("tree depth is " + list.size());
        list.forEach(integers -> {
            integers.forEach(i -> System.out.print(i));
            System.out.println("");
        });
    }
}

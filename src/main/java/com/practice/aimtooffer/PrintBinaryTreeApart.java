package com.practice.aimtooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * task13请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintBinaryTreeApart {

    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        if (pRoot == null) return resultList;
        nodes.add(pRoot);
        int i = 0;
        int start = 0;
        int end = 1;
        ArrayList<Integer> rowList = new ArrayList<>();
        while (!nodes.isEmpty()) {
            TreeNode node;
            if ((i & 1) == 0) {
                node = nodes.removeLast();
                if (node.left != null) {
                    nodes.addFirst(node.left);
                }
                if (node.right != null) {
                    nodes.addFirst(node.right);
                }
            } else {
                node = nodes.removeFirst();
                if (node.right != null) {
                    nodes.addLast(node.right);
                }
                if (node.left != null) {
                    nodes.addLast(node.left);
                }
            }
            rowList.add(node.val);
            start++;

            if (start == end) {
                i++;
                start = 0;
                end = nodes.size();
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
        TreeNode head = new TreeNode(8);
        TreeNode left = new TreeNode(6);
        TreeNode right = new TreeNode(7);
        head.left = left;
        head.right = right;
        TreeNode leftleft = new TreeNode(1);
        TreeNode leftright = new TreeNode(2);
        TreeNode rightleft = new TreeNode(3);
        TreeNode rightright = new TreeNode(4);
        left.left = leftleft;
        left.right = leftright;
        right.left = rightleft;
        right.right = rightright;

        List<ArrayList<Integer>> list = new PrintBinaryTreeApart().print(head);
        System.out.println("tree depth is " + list.size());
        list.forEach(integers -> {
            integers.forEach(i -> System.out.print(i));
            System.out.println("");
        });
    }
}

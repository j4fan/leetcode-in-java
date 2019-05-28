package com.practice.aimtooffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * task13请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintBinaryTreeApart {

    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        if (pRoot == null) return null;
        nodes.add(pRoot);
        int i = 0;
        while (nodes.size() > 0) {
            ArrayList<Integer> printList = new ArrayList<>();
            LinkedList<TreeNode> newNodes = new LinkedList<>();
            Iterator<TreeNode> reversteIter = nodes.descendingIterator();
            while (reversteIter.hasNext()) {
                TreeNode node = reversteIter.next();
                printList.add(node.val);
                if (i % 2 == 0) {
                    if (node.left != null) {
                        newNodes.add(node.left);
                    }
                    if (node.right != null) {
                        newNodes.add(node.right);
                    }
                } else {
                    if (node.right != null) {
                        newNodes.add(node.right);
                    }
                    if (node.left != null) {
                        newNodes.add(node.left);
                    }
                }
            }
            nodes = newNodes;
            arrayLists.add(printList);
            i++;
        }
        return arrayLists;
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

    }
}

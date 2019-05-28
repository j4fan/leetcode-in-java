package com.practice.aimtooffer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * task12从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintBinaryTree {

    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> resultList = new ArrayList();
        LinkedBlockingQueue<TreeNode> priorityQueue = new LinkedBlockingQueue<>();
        priorityQueue.offer(root);
        while(!priorityQueue.isEmpty()){
            TreeNode node =priorityQueue.poll();
            resultList.add(node.val);
            if(node.left!=null){
                priorityQueue.offer(node.left);
            }
            if(node.right!=null){
                priorityQueue.offer(node.right);
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
        List list = printFromTopToBottom(root);
        list.forEach(i-> System.out.println(i));
    }
}

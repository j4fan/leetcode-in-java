package com.practice.aimtooffer;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
 * 中序遍历:左中右
 */
public class TreeLinkNodeGetNext {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else if (pNode.next != null) {
            while (pNode.next != null) {
                if (pNode.next.left == pNode) {
                    return pNode.next;
                } else {
                    pNode = pNode.next;
                }
            }
        }
        return null;
    }


    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}

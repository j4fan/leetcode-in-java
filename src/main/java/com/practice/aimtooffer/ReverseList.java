package com.practice.aimtooffer;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(2);
        head.next = second;
        second.next = third;
        third.next = null;
        ListNode reverseHead = reverseList(head);
        while (reverseHead != null) {
            System.out.println(reverseHead.val);
            reverseHead = reverseHead.next;
        }
    }
}

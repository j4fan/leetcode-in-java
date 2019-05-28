package com.practice.aimtooffer;

/**
 * task 4输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {

    public ListNode findKthToTail(ListNode head, int k) {
        if (k <= 0) return null;
        if (head == null) return null;
        ListNode formal = head;
        ListNode letter = head;
        //formal走k步
        for (int i = 0; i < k - 1; i++) {
            if (formal.next == null) return null;
            formal = formal.next;
        }
        while (formal.next != null) {
            formal = formal.next;
            letter = letter.next;
        }
        return letter;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

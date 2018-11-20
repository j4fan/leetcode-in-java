package com.practice.aimtooffer;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryNodeOfLoop {

    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode node = meetNode(pHead);
        ListNode tmp = node;
        int count = 1;
        while (node.next != tmp) {
            node = node.next;
            count++;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        for (int i = 0; i < count; i++) {
            fast = fast.next;
        }
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    private ListNode meetNode(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while (fast.next.next != slow.next) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.next;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

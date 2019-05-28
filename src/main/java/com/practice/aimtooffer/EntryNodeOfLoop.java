package com.practice.aimtooffer;

/**
 * task2给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryNodeOfLoop {

    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        //创建两个指针，一个速度为1，一个速度为2
        ListNode fast = pHead;
        ListNode slow = pHead;
        int lengthOfCircle = 0;
        do {
            if (fast.next == null || fast.next.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            lengthOfCircle++;
        } while (fast != slow);
        ListNode formal = pHead;
        ListNode letter = pHead;
        for (int i = 0; i < lengthOfCircle; i++) {
            letter = letter.next;
        }
        while (formal != letter) {
            formal = formal.next;
            letter = letter.next;
        }
        return formal;
    }

    public static void main(String[] args) {
        EntryNodeOfLoop entryNodeOfLoop = new EntryNodeOfLoop();
        ListNode node = new ListNode(5);
        ListNode next = new ListNode(3);
        ListNode end = new ListNode(4);
        node.next = next;
        next.next = end;
        ListNode entry = entryNodeOfLoop.entryNodeOfLoop(node);
        System.out.println(entry);
    }


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

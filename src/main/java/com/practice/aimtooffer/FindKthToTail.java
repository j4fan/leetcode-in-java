package com.practice.aimtooffer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {

    public ListNode findKthToTail(ListNode head,int k){
        if(head==null){
            return null;
        }
        if(k<=0){
            return null;
        }
        ListNode pre = head;
        for(int i=1;i<k;i++){
            if(head.next==null){
                return null;
            }
            head = head.next;
        }
        while(head.next!=null){
            head = head.next;
            pre = pre.next;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

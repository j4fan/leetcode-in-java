package com.practice.datastructures;

public class LRUByList<T> {

    class Node<T> {
        private T val;
        private Node pre;
        private Node next;

        Node(T t) {
            this.val = t;
        }
    }

    private volatile int size = 0;
    private volatile int threshhold = 3;
    private Node head;
    private Node tail;

    LRUByList() {

    }


    private Node put(T t) throws Exception {
        if (t == null) {
            throw new Exception("can't put key null value");
        }
        if (size == 0) {
            head = new Node(t);
            tail = head;
        } else {
            Node tmp = head;
            head = new Node(t);
            head.next = tmp;
            tmp.pre = head;
        }
        size++;
        if (size > threshhold) {
            Node tmp = tail.pre;
            tmp.next = null;
            tail = tmp;
            size--;
        }
        return head;
    }

    @Override
    public String toString() {
        Node node = head;
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val);
            node = node.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        LRUByList<Integer> lruByList = new LRUByList<>();
        lruByList.put(0);
        lruByList.put(1);
        lruByList.put(2);
        lruByList.put(3);
        lruByList.put(4);
        System.out.println(lruByList.toString());
    }

}

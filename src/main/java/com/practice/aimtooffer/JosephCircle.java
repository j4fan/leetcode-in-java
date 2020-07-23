package com.practice.aimtooffer;

/**
 * task26 约瑟夫环
 * m个人围成一个圈，指定一个数字n,从第一个人开始报数，每轮报到n的选手出局，由下一个人接着从头开始报，最后一个人是赢家。其中m>1,n>2。
 */
public class JosephCircle {

    private int solutionOne(int m,int n){
        //形成循环链表
        Node head = createCircleNode(m);
        int count =1;
        Node pre = null;
        Node cur = head;
        while(!cur.equals(pre)){
            if(count==n){
                count =1 ;
                cur = cur.next;
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
                count++;
            }
        }
        return cur.value;
    }

    public static void main(String[] args) {
        JosephCircle circle = new JosephCircle();
        System.out.println(circle.solutionOne(6,2));
    }

    private Node createCircleNode(int m){
        Node head = new Node(1);
        Node tmp = head;
        for(int i=1;i<m;i++){
            Node node = new Node(i+1);
            tmp.next = node;
            tmp = node;
        }
        tmp.next = head;
        return head;
    }





    class Node{

        public Node(int value) {
            this.value = value;
        }

        int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        Node next;

    }

}

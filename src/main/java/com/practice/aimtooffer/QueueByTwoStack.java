package com.practice.aimtooffer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class QueueByTwoStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.empty()&&stack2.empty()){
            return -1;
        }
        if (stack2.empty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueByTwoStack queueByTwoStack = new QueueByTwoStack();
        queueByTwoStack.push(1);
        queueByTwoStack.push(2);
        System.out.println(queueByTwoStack.pop());
        queueByTwoStack.push(4);
        System.out.println(queueByTwoStack.pop());
        System.out.println(queueByTwoStack.pop());
    }

}

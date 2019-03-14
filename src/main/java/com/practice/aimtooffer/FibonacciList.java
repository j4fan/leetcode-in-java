package com.practice.aimtooffer;

/**
 * Fibonacci
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class FibonacciList {

    /**
     * using recursion
     *
     * @param n
     * @return
     */
    public int FibonacciInRecursion(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return FibonacciInRecursion(n - 1) + FibonacciInRecursion(n - 2);
    }

    /**
     * using loop to reduce the use of space
     */
    public int FinonacciInLoop(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int formal = 0;
        int letter = 1;
        for (int i = 1; i < n; i++) {
            int tmp = formal + letter;
            formal = letter;
            letter = tmp;
        }
        return letter;
    }

    public static void main(String[] args) {
        System.out.println(new FibonacciList().FibonacciInRecursion(10));
        System.out.println(new FibonacciList().FinonacciInLoop(10));

    }

}

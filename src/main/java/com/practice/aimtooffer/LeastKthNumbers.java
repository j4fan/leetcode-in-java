package com.practice.aimtooffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class LeastKthNumbers {

    public ArrayList<Integer> GetLeastNumbersSolution(int[] input, int k) {
        if (input.length <= 0 || k <= 0 || k > input.length) {
            return new ArrayList();
        }
        PriorityQueue<Integer> leastQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : input) {
            if (leastQueue.size() < k) {
                leastQueue.add(num);
            } else if (leastQueue.peek() > num) {
                leastQueue.poll();
                leastQueue.add(num);
            }
        }
        ArrayList result = new ArrayList();
        while (leastQueue.size() > 0) {
            result.add(leastQueue.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        LeastKthNumbers leastKthNumbers = new LeastKthNumbers();
        System.out.println(leastKthNumbers.GetLeastNumbersSolution(nums, 4).stream().map(i -> i.toString()).collect(Collectors.joining()));
    }

}

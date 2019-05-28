package com.practice.aimtooffer;

/**
 * Problem
 * <p>
 * Given a two-dimensional array of positive and negative integers, a sub-rectangle is any contiguous sub-array of size 1 x 1 or greater located within the whole array. The sum of a rectangle is the sum of all the elements in that rectangle. In this problem the sub-rectangle with the largest sum is referred to as the maximal sub-rectangle.
 * <p>
 * As an example, the maximal sub-rectangle of the array:
 * <p>
 * 0 -2 -7 0
 * 9 2 -6 2
 * -4 1 -4 1
 * -1 8 0 -2
 * <p>
 * is in the lower left corner:
 * <p>
 * 9 2
 * -4 1
 * -1 8
 * <p>
 * and has a sum of 15.
 * <p>
 * The input consists of an N x N array of integers. The input begins with a single positive integer N on a line by itself, indicating the size of the square two-dimensional array. This is followed by N 2 integers separated by whitespace (spaces and newlines). These are the N 2 integers of the array, presented in row-major order. That is, all numbers in the first row, left to right, then all numbers in the second row, left to right, etc. N may be as large as 100. The numbers in the array will be in the range [-127,127].
 * <p>
 * <p>
 * Output
 * <p>
 * Output the sum of the maximal sub-rectangle.
 * <p>
 * <p>
 * Example
 * <p>
 * Input
 * <p>
 * 4
 * 0 -2 -7 0 9 2 -6 2
 * -4 1 -4 1 -1
 * 8 0 -2
 * <p>
 * Output
 * <p>
 * 15
 */
public class MaxSubMatrix {

    private int maxOfMatrix(int[][] nums) {
        if (nums.length <= 0 || nums[0].length <= 0) {
            throw new RuntimeException("矩阵输入不合法");
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int tmpmax = 0;
                int dp = 0;
                for (int k = 0; k < nums[0].length; k++) {
                    if (dp < 0) {
                        dp = sumOfColumn(i, j, k, nums);
                    } else {
                        dp = dp + sumOfColumn(i, j, k, nums);
                    }
                    if (dp > tmpmax) {
                        tmpmax = dp;
                    }
                }
                if (tmpmax > max) {
                    max = tmpmax;
                }
            }
        }
        return max;
    }

    /**
     *
     */
    private int sumOfColumn(int start, int end, int column, int[][] nums) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i][column];
        }
        return sum;
    }

    private int maxOfArray(int[] nums) {
        if (nums.length <= 0) {
            throw new RuntimeException("数组输入不合法");
        }
        int result = 0, dp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp < 0) {
                dp = nums[i];
            } else {
                dp = dp + nums[i];
            }
            if (dp > result) {
                result = dp;
            }
        }
        //返回sum
        return result;
    }

    public static void main(String[] args) {
        //test max of array
        MaxSubMatrix maxSubMatrix = new MaxSubMatrix();
        int[] nums = new int[]{0, -2, -7, 0, 6, 9, -1, 8, 2, -6, 2};
        System.out.println(maxSubMatrix.maxOfArray(nums));

        //test max of matrix
        int[][] matrix = new int[][]{{0, -2, -7, 0}, {9,2,-6,2}, {-4,1,-4,1}, {-1,8,0,-2}};
        System.out.println(maxSubMatrix.maxOfMatrix(matrix));
    }
}

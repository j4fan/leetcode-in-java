package com.practice.aimtooffer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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


    private int maxOfMatrix(int[][]nums){
        if(nums.length<=0||nums[0].length<=0){
            throw new RuntimeException("矩阵输入不合法");
        }
        int sum=0,dpl=0,dpc=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){

            }
        }
        return 0;
    }

    private List maxOfArray(int[] nums) {
        if (nums.length <= 0) {
            throw new RuntimeException("数组输入不合法");
        }
        int result = 0, dp = 0;
        List<Integer> resultList = null;
        List<Integer> tmpList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(dp<0){
                dp = nums[i];
                tmpList.clear();
                tmpList.add(nums[i]);
            }else{
                dp = dp+nums[i];
                tmpList.add(nums[i]);
            }
            if (dp > result) {
                result = dp;
                resultList = new ArrayList<>(tmpList);
            }
        }
        //返回sum
        //return result;
        //返回结果子数组
        return resultList;
    }

    public static void main(String[] args) {
        MaxSubMatrix maxSubMatrix = new MaxSubMatrix();
        int[] nums = new int[]{0, -2, -7, 0,6, 9,-1,8, 2, -6, 2};
        System.out.println(maxSubMatrix.maxOfArray(nums).stream().map(i->i.toString()).collect(Collectors.joining(",")));
    }
}

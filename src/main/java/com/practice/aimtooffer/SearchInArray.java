package com.practice.aimtooffer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class SearchInArray {

    public static boolean find(int target, int[][] array) {
        int row = array.length - 1;
        int col = 0;
        while (row >= 0 && col <= array[0].length - 1) {
            if (array[row][col] == target) {
                return true;
            } else if (array[row][col] < target) {
                col++;
                continue;
            } else {
                row--;
                continue;
            }
        }
        return false;
    }

    //test case
    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(find(7, array));
        System.out.println(find(15, array));
    }
}

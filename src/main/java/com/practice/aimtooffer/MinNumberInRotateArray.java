package com.practice.aimtooffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray {

    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        while (left != right) {
            int mid = (left + right) / 2;
            if (array[left] > array[mid]) {
                right = mid;
            } else if (array[left] < array[mid]) {
                left = mid;
            } else {
                left = left + 1;
                if (array[left-1] > array[left]) {
                    return array[left];
                }
            }
        }
        return array[left];
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{1,2,3,4,5,0};
        MinNumberInRotateArray minNumberInRotateArray = new MinNumberInRotateArray();
        System.out.println(minNumberInRotateArray.minNumberInRotateArray(arrays));
        int[] arraysTwo = new int[]{1,1,1,1,0,1};
        System.out.println(minNumberInRotateArray.minNumberInRotateArray(arraysTwo));
    }

}

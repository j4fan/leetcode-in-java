package com.practice.aimtooffer;

/**
 * task20逆时针旋转数组
 */
public class RotateMatrix {

    private int[][] rotate(int[][] source) {
        //先沿对角线旋转 source[i][j]->source[j][i]
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < i; j++) {
                swap(source,i,j);
            }
        }
        //在沿中心线替换
        for (int i = 0; i < source.length / 2; i++) {
            for (int j = 0; j < source[0].length; j++) {
                swapVerticle(source,i,j);
            }
        }
        return source;
    }

    //对角互换
    private void swap(int[][]source, int i,int j) {
        int tmp = source[i][j];
        source[i][j] = source[j][i];
        source[j][i] = tmp;
    }

    //水平对称互换
    private void swapVerticle(int[][]source, int i,int j) {
        int tmp = source[i][j];
        source[i][j] = source[source.length-i-1][j];
        source[source.length-i-1][j] = tmp;
    }

    private void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        RotateMatrix rotateMatrix = new RotateMatrix();
        rotateMatrix.printMatrix(matrix);
        System.out.println("");
        rotateMatrix.printMatrix(rotateMatrix.rotate(matrix));
    }
}

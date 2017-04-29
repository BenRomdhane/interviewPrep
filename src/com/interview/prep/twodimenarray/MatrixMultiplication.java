package com.interview.prep.twodimenarray;

/**
 * Created by Nikitash Pawar on 2/18/2017.
 */
public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] m1={{1,2,3},{4,5,6},{7,8,9}};
        int[][] m2={{1,2,3},{4,5,6},{7,8,9}};
        int[][] result=new int[3][3];

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m1.length; k++) {
                    result[i][j]=result[i][j]+(m1[i][k]*m2[k][j]);
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j]+",");
            }
            System.out.println();
        }


    }
}

package com.interview.prep.arrayandstrings;

/**
 * Created by Nikitash Pawar on 11/20/2016.
 */
public class RotateMatrix {
    public static void main(String[] args) {

        char[][] matrix ={
                {'a','b','c'},
                {'e','f','g'},
                {'i','j','k'}
        };

/*        char[][] matrix ={
                {'a','b','c','d'},
                {'e','f','g','h'},
                {'i','j','k','l'},
                {'m','n','o','p'}
        };*/

/*        char[][] matrix ={
                {'a','b'},
                {'m','n'}
        };*/
        printMatrix(matrix);
        System.out.println("====");
        rotateMatrix(matrix);
        System.out.println("====");
        printMatrix(matrix);
    }

    private static void rotateMatrix(char[][] matrix){
        int numberOfIterations=matrix.length/2;
        int offset=matrix.length-1;
        int depth=offset;
        char p1,p2,p3,p4;

        for (int row=0;row<numberOfIterations;row++,depth--)
        {
            for (int col=row;col<depth;col++)
            {
                if(row==col)
                {
                    p1=matrix[row][col];
                    p2=matrix[row][depth];
                    p3=matrix[depth][depth];
                    p4=matrix[depth][col];


                    matrix[row][col]=p4;
                    matrix[row][depth]=p1;
                    matrix[depth][depth]=p2;
                    matrix[depth][col]=p3;
                }
                else
                {
                    p1=matrix[row][col];
                    p2=matrix[col][depth];
                    p3=matrix[depth][depth-col];
                    p4=matrix[depth-col][row];


                    matrix[row][col]=p4;
                    matrix[col][depth]=p1;
                    matrix[depth][depth-col]=p2;
                    matrix[depth-col][row]=p3;
                }

/*                System.out.println("====");
                printMatrix(matrix);
                System.out.println("====");*/

            }

        }

    }


    private static void printMatrix(char[][] matrix) {
        for (int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}

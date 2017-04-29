package com.interview.prep.twodimenarray;

/**
 * Created by Nikitash Pawar on 12/29/2016.
 */
public class Zeofy {

    public static void main(String[] args) {
        int[][] matrix ={
                {1,2,0},
                {4,3,6},
                {7,8,9}
        };

        int rows[] = new int[matrix.length];
        int cols[] = new int[matrix.length];
        int counter=0;

        for(int row=0; row<matrix.length;row++)
        {
            for(int col=0;col<matrix.length;col++)
            {
                if(matrix[row][col]==0)
                {
                    rows[counter]=row;
                    cols[counter]=col;
                    counter++;
                }
            }
        }

        for (int i=0;i<counter;i++)
        {
            int r=rows[i],w=cols[i];

                for (int c=0;c<matrix.length;c++)
                {
                    matrix[r][c]=0;
                }
                for (int k=0;k<matrix.length;k++)
                {
                    matrix[k][w]=0;
                }

        }

        for (int i=0;i<matrix.length;i++)
        {
            for (int j=0;j<matrix.length;j++)
            {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}

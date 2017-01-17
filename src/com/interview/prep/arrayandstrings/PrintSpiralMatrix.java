package com.interview.prep.arrayandstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Nikitash Pawar on 12/29/2016.
 */
public class PrintSpiralMatrix {

    public static void main(String[] args) {


        List<List<Integer>> a= Arrays.asList(Arrays.asList(1),Arrays.asList(4),Arrays.asList(9));
       // List<List<Integer>> a= Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(4,5,6),Arrays.asList(7,8,9));
       // List<List<Integer>> a= Arrays.asList(Arrays.asList(1));

/*        int [][] array=new int[a.size()][a.get(0).size()];
        int row=0;
        int col=0;

        for(List<Integer> arr: a)
        {
            for(Integer x: arr)
            {
                array[row][col]=x;
                col++;
            }
            row++;
            col=0;
        }*/

/*        int [][] array=
                {       {44},
                        {36},
                        {395},
                        {179},
                        {249},
                        {349},
                        {5},
                        {139}
                };*/
/*        int [][] array={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };*/


/*        int [][] array={
                {1,2,3},
                {4,5,6}
        };*/

        int [][] array={
                {1,2,3}
        };
/*        int [][] array={
                {1}
        };*/
/*        int [][] array={
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12}
        };*/

/*        int [][] array={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};*/

        int numberOfColumns=array[0].length-1;
        int numberOfRows=array.length-1;

        for (int layer = 0; layer<=array.length/2; layer++,numberOfColumns--,numberOfRows--)
        {
            if(numberOfColumns==layer && numberOfRows <=1 && numberOfColumns==numberOfRows)
            {
                System.out.println(array[numberOfRows][numberOfColumns]);
            }
            for (int i=layer;i<numberOfColumns;i++)
            {
                System.out.println(array[layer][i]);
            }
            for (int j=layer;j<numberOfRows;j++)
            {
                System.out.println(array[j][numberOfColumns]);
            }

            for (int k=numberOfColumns;k>layer;k--)
            {
                System.out.println(array[numberOfRows][k]);
            }

            if(numberOfRows>0 && numberOfColumns==0 && layer!=array.length/2){
                System.out.println(array[numberOfRows][numberOfColumns]);
               break;
            }

            for (int l=numberOfRows;l>layer;l--)
                {
                    System.out.println(array[l][layer]);
                }
        }

    }
}

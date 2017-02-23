package com.interview.prep.algorithms;

import com.interview.prep.util.PrintArray;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Nikitash Pawar on 2/17/2017.
 */
public class InsertionSort {

    public static void main(String[] args) {
        Integer[] array={7,5,1,0,9,5};
        int temp;
        PrintArray<Integer> printer=new PrintArray<>();

        for (int i = 0; i < array.length; i++) {

            for (int j = i; j-1 >= 0 ; j--) {
                System.out.println("checking :"+array[j-1]+" with: "+array[j]);
                if(array[j]<array[j-1])
                {
                     System.out.println("swapping :"+array[j-1]+" with: "+array[j]);
                     temp=array[j-1];
                     array[j-1]=array[j];
                     array[j]=temp;
                }
            }
            printer.print(array);
        }
        printer.print(array);


    }

}

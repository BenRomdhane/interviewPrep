package com.interview.prep.algorithms;

import com.interview.prep.util.PrintArray;

/**
 * Created by Nikitash Pawar on 1/17/2017.
 */
public class SelectionSort {


    public static void main(String[] args) {
        Integer[] array={3,6,3,8,9,0,35,67};
        PrintArray<Integer> printer= new PrintArray<>();
        selectionSort(array);
        printer.print(array);
    }

    private static void selectionSort(Integer[] array) {
        Integer iMin;
        Integer temp;
        for (int i=0;i<array.length;i++)
        {
            iMin=i;
            for (int j=i+1;j<array.length-1;j++)
            {
                if(array[j]<array[iMin])
                {
                    iMin=j;
                }
            }
            temp=array[i];
            array[i]=array[iMin];
            array[iMin]=temp;
        }

    }


}

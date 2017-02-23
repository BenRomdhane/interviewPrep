package com.interview.prep.algorithms;

import com.interview.prep.util.PrintArray;

/**
 * Created by Nikitash Pawar on 2/20/2017.
 */
public class QuickSort {

    public static void main(String[] args) {
        PrintArray<Integer> printer=new PrintArray<>();
        Integer[] input= {5,3,7,4,8,1,9,0};
        //partition(input,0,input.length);
        quicksort(input,0,input.length);
        System.out.print("O-> ");
        printer.print(input);

    }

    private static void quicksort(Integer[] input, int start, int end) {
        PrintArray<Integer> printer=new PrintArray<>();
        System.out.print("I->");
        printer.print(input);
        System.out.println();
        if (start<end)
        {
            Integer partitionIndex = partition(input, start, end);
            quicksort(input,start,partitionIndex-1);
            quicksort(input,partitionIndex,end);
        }else{
            System.out.println("Return");
        }

    }

    private static Integer partition(Integer[] input, int start, int end) {
        System.out.println("S-> "+start);
        System.out.println("E-> "+end);

        PrintArray<Integer> printer=new PrintArray<>();
        Integer pivot=input[end-1];
        System.out.println("P-> " +pivot);
        Integer pIndex=start;
        Integer temp;
        for (int i = start; i < end; i++) {
            if(input[i]<=pivot)
            {
                temp=input[pIndex];
                input[pIndex]=input[i];
                input[i]=temp;
                pIndex++;

            }
        }
        System.out.print("PO-> ");
        printer.print(input);
        System.out.println();
        System.out.println("P Index-> "+pIndex);
        return pIndex;
    }
}

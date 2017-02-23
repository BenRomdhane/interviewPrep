package com.interview.prep.algorithms;

import com.interview.prep.util.PrintArray;

/**
 * Created by Nikitash Pawar on 2/19/2017.
 */
public class MergeSort {

    public static void main(String[] args) {
        PrintArray<Integer> printer=new PrintArray<>();
        Integer[] left={1,2,3};
        Integer[] right={5,6,7,8};
        Integer [] out=new Integer[left.length+right.length];
        //merge(left,right,out);
        Integer [] input={8,6,4,9,3,5,7,0};
        mergesort(input);
        System.out.println();
        printer.print(input);

    }

    private static void mergesort(Integer[] input) {
        PrintArray<Integer> printer=new PrintArray<>();
        Integer[] left=new Integer[input.length/2];
        Integer[] right;
        if(input.length%2==0)
        {
            right=new Integer[input.length/2];
        }
        else {
            right=new Integer[input.length/2+1];
        }

        System.out.println();
        System.out.print("I-> ");
        printer.print(input);
        System.out.println();

        if(input.length<2)
        {
            return;
        }
        int mid=input.length/2;
        for (int i = 0; i < mid; i++) {
        left[i]=input[i];
        }
        for (int i = mid; i <input.length; i++) {
        right[i-mid]=input[i];
        }
        System.out.print("L-> ");
        printer.print(left);
        System.out.println();
        System.out.print("R-> ");
        printer.print(right);
        mergesort(left);
        mergesort(right);
        merge(left,right,input);
    }

    private static void merge(Integer[] left, Integer[] right, Integer[] out) {
        PrintArray<Integer> printer=new PrintArray<>();

        int l=0,r=0,o=0;
        while (l<left.length && r<right.length)
        {
            if(left[l]<right[r])
            {
                out[o]=left[l];
                l++;
            }
            else if(left[l]>=right[r])
            {
                out[o]=right[r];
                r++;
            }
            o++;
        }

        while (l<left.length)
        {
            out[o]=left[l];
            o++;
            l++;
        }
        while (r<right.length)
        {
            out[o]=right[r];
            o++;
            r++;

        }


        System.out.println();
        System.out.print("M-> ");
        printer.print(out);
        System.out.println();
    }


}

package com.interview.prep.mobileiron;

import java.util.Arrays;

/**
 * Created by Nikitash Pawar on 6/14/2017.
 */
public class Solution1 {

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6, 7};

        //printArray(arr, 7);

        int[] a={1,2,4,3};
        int[] rotate={0,2};
        getMaxElementIndices(a,rotate);

    }

    static int[] getMaxElementIndices(int[] a, int[] rotate) {

        int[] output=new int[rotate.length];
        for (int i = 0; i < rotate.length; i++) {
            int[] curr = Arrays.copyOf(a, a.length);
            leftRotate(curr, rotate[i], a.length);
            output[i]=findMaxLocation(curr);
        }
    return output;
    }

    static  int findMaxLocation(int[] array){
        int index = 0;
        int largest = Integer.MIN_VALUE;
        for ( int i = 0; i < array.length; i++ )
        {
            if ( array[i] > largest )
            {
                largest = array[i];
                index = i;
            }
        }
        return index;
    }


    static void leftRotate(int arr[], int d, int n)
    {
        int i;
        for (i = 0; i < d; i++)
            leftRotatebyOne(arr, n);
    }

    static void leftRotatebyOne(int arr[], int n)
    {
        int i, temp;
        temp = arr[0];
        for (i = 0; i < n - 1; i++)
            arr[i] = arr[i + 1];
        arr[i] = temp;
    }

    static void printArray(int arr[], int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }
}

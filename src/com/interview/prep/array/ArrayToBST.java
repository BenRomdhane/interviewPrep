package com.interview.prep.array;

/**
 * Created by Nikitash Pawar on 5/21/2017.
 */
public class ArrayToBST {

    public static int counter=0;

    public static void main(String[] args) {

        int[] array={7, 6, 5, 4 ,3, 2, 1};
        int[] output=new int[array.length];

        convert(array,output,0,array.length-1);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }

    private static void convert(int[] array, int[] output, int left, int right) {

        int mid=(left+right)/2;
        output[counter]=array[mid];
        counter++;

        if(left==right){
            return;
        }
        convert(array,output,left,mid-1);
        convert(array,output,mid+1,right);

    }
}

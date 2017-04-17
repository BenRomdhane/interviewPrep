package com.interview.prep.algorithms;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nikitash Pawar on 4/12/2017.
 */
public class RadixSortUsingList {

    public static void main (String[] args)
    {
        int input[] = {170, 45, 75, 90, 802, 24, 2, 66};
        /*String inputs[]={"ja","bas","cat","aad"};
        input=convertToIntArr(inputs);
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(inputs[i]+" ,");
        }
        System.out.println();
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
            System.out.print(" ");
        }
        System.out.println();*/
        radixSort(input);

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }

    }

    private static int[] convertToIntArr(String[] inputs) {
        int[] output=new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            char[] chars = inputs[i].toCharArray();
            for (int j = 0; j <chars.length; j++) {

                output[i]+=chars[j]-'a';
            }
        }
        return output;
    }

    private static void radixSort(int[] input) {
        List<Integer>[] buckets=new ArrayList[10];
        int m = getMax(input, input.length);
        int numberOfIterations=1;

        //identify the number of times i need to iterate
        while ((m/10)!=0){
            m=m/10;
            numberOfIterations++;
        }

        for (int i = 0; i < buckets.length; i++) {
            buckets[i]=new ArrayList<Integer>();
        }
        int tmp=-1,divisor=1;
        while (numberOfIterations != 0){

            //split input into the buckets
            for (Integer i : input) {
                tmp=i/divisor;
                buckets[tmp%10].add(i);
            }
            //load new order of elements into the array
            int a=0;
            for (int b = 0; b <10; b++) {
                for (Integer i:buckets[b]){
                    input[a++]=i;
                }
                buckets[b].clear();
            }
        divisor *= 10;
        numberOfIterations--;
        }
    }

    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
}

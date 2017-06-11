package com.interview.prep.array;

import com.interview.prep.util.PrintArray;

import java.util.Arrays;

/**
 * Created by Nikitash Pawar on 5/20/2017.
 */
public class TripletSumInArray {

    public static void main(String[] args) {


        int[] input={12, 3, 4, 1, 6, 9};
        int sum=24;
        int left;
        int right;

        Arrays.sort(input);

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }

        for (int i = 0; i < input.length; i++) {
            left=i+1;
            right=input.length-1;

            while(left<right){
                if(input[left]+input[right]+input[i] ==sum){
                    System.out.println(input[left]+","+input[right]+","+input[i]);
                    break;
                }else if(input[left]+input[right]+input[i] < sum){
                    left++;
                }else {
                    right--;
                }
            }
        }
    }
}

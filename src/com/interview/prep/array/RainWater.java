package com.interview.prep.array;

/**
 * Created by Nikitash Pawar on 5/1/2017.
 */
public class RainWater {

    public static void main(String[] args) {
        int[] input={3,0,0,2,0,4,3,1};

        int left=Integer.MIN_VALUE;
        int sum=0;

        for (int i = 0; i < input.length; i++) {

            if(input[i]>left){
                left=input[i];
            }else{
                sum=sum+(left-input[i]);
            }

        }
        System.out.println(sum);
    }

}

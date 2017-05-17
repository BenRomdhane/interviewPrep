package com.interview.prep.array;

/**
 * Created by Nikitash Pawar on 5/15/2017.
 */
public class MaxSumWithoutAdjacents {

    public static void main(String[] args) {

        int[] input={ 3 ,2 ,5 ,10 ,7};
        int counter=0;
        int evenSum=0;
        int oddSum=0;
        while (counter!=input.length){

            if (counter%2==0){
                evenSum+=input[counter];
            }else{
                oddSum+=input[counter];
            }
            counter++;
        }
        int max=Integer.max(evenSum,oddSum);
        System.out.println(max);
    }
}

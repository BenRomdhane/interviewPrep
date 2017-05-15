package com.interview.prep.array;

/**
 * Created by Nikitash Pawar on 5/13/2017.
 */
public class LongestIncreasingSubSequence {

    public static void main(String[] args) {

        int[] input={10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(findLISC(input));

    }

    private static int findLISC(int[] input) {

        int max=0;
        int tempMax=0;
        int prev;
        for (int i = 0; i <input.length; i++) {

            tempMax = 0;
            prev=0;

            for (int j = i; j < input.length; j++) {

                if(prev<input[j]){
                    tempMax++;
                }

                prev=input[j];
            }
            max=Integer.max(max,tempMax);
        }

        return max;
    }
}

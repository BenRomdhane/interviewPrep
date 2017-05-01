package com.interview.prep.array;

/**
 * Created by Nikitash Pawar on 5/1/2017.
 */
public class KadanesAlgorithm {

    public static void main(String[] args) {

        int[] input= {-2, -3, 4, -1, -2, 1, 5, -3};
        int sumTillNow=0;

        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < input.length; i++) {
            max_ending_here=max_ending_here+input[i];
            if(max_ending_here>max_so_far){
                //update the max sum
                max_so_far=max_ending_here;
            }

            //if the sum so far is less that the
            //value added then make sum so far as zero
            if(max_ending_here < input[i]){
                max_ending_here=0;
            }
        }
        System.out.println(max_so_far);


    }
}

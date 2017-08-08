package com.interview.prep.array;

/**
 * Created by Nikitash Pawar on 5/1/2017.
 */
public class KadanesAlgorithm {


    /**
     *
     * Simple idea of the Kadane's algorithm is to look for all positive
     * contiguous segments of the array (max_ending_here is used for this).
     * And keep track of maximum sum contiguous segment among all positive
     * segments (max_so_far is used for this). Each time we get a positive
     * sum compare it with max_so_far and update max_so_far if it is greater
     * than max_so_far
     *
     *
     * Initialize:
     max_so_far = 0
     max_ending_here = 0

     Loop for each element of the array
     (a) max_ending_here = max_ending_here + a[i]
     (b) if(max_ending_here < 0)
     max_ending_here = 0
     (c) if(max_so_far < max_ending_here)
     max_so_far = max_ending_here
     return max_so_far
     *
     * @param args
     */
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
        System.out.println(max_ending_here);


    }
}

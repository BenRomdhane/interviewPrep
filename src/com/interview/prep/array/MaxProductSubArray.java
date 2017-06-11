package com.interview.prep.array;

/**
 * Created by Nikitash Pawar on 5/21/2017.
 */
public class MaxProductSubArray {

    public static void main(String[] args) {
        //int[] input={2 ,3 ,4 ,5 ,-1 ,0 };
        int[] input={8, -2, -2, 0, 8, 0, -6, -8, -6 ,-1};

        int maxProduct=input[0];
        int maxProductTillNow=input[0];

        for (int i = 1; i <input.length; i++) {

            maxProductTillNow=maxProductTillNow*input[i];
            if(input[i]==0)
            {
                maxProductTillNow=1;
            }
            maxProduct=Integer.max(maxProduct,maxProductTillNow);

        }
        System.out.println(maxProduct);
    }
}

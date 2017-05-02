package com.interview.prep.array;

/**
 * Created by Nikitash Pawar on 5/1/2017.
 */
public class MaxSumIncreasingSUbSeq {

    public static void main(String[] args) {

        int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
        int n=arr.length;

        int i, j, max = 0;
        int msis[] = new int[n];

        /* Initialize msis values for all indexes */
        for ( i = 0; i < n; i++ )
            msis[i] = arr[i];

        /* Compute maximum sum values in bottom up manner */
        /**
         * if the the previous element is less than the current
         * then sum is equals to current value plus the sum of
         * the elements till previous most least element
         */
        for ( i = 1; i < n; i++ )
            for ( j = i-1; j >= 0; j-- )
                if ( arr[i] > arr[j]){
                    msis[i] = msis[j] + arr[i];
                    break;
                }


        /* Pick maximum of all msis values */
        for ( i = 0; i < n; i++ )
            if ( max < msis[i] )
                max = msis[i];

        System.out.println(max);
    }
}

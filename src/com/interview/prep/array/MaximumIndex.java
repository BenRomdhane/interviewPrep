package com.interview.prep.array;

/**
 * Created by Nikitash Pawar on 5/13/2017.
 */
public class MaximumIndex {

    /**
     * create a min array starting from left most
     * store the min element encounterd at any point starting
     * from left.
     *
     * similarly create a max array starting from right most
     * because we need to find max dist betn i and j
     *
     * parallely iterate both arrays comparing element in the min
     * array to the max array untill we encounter an element in the max
     * array that has an element lesser than the element in the min array.
     * @param args
     */
    public static void main(String[] args) {

        /**
         * Given an array A of integers,
         * find the maximum of j - i subjected to
         * the constraint of A[i] <= A[j].
         */
        int[] input={3, 5, 4, 2};
        int maxDiff=0;
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j <input.length; j++) {
                if (input[i]<input[j]){
                    maxDiff=Integer.max(maxDiff,j-i);
                }
            }
            System.out.println(maxDiff);
        }

        int arr[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
        int n = arr.length;
        int diff = maxIndexDiff(input, input.length);
        System.out.println(diff);
    }

    static int maxIndexDiff(int arr[], int n)
    {
        int maxDiff;
        int i, j;

        int RMax[] = new int[n];
        int LMin[] = new int[n];

        /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = arr[0];
        for (i = 1; i < n; ++i)
            LMin[i] = min(arr[i], LMin[i - 1]);

        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j)
            RMax[j] = max(arr[j], RMax[j + 1]);

        /* Traverse both arrays from left to right to find optimum j - i
           This process is similar to merge() of MergeSort */
        i = 0; j = 0; maxDiff = -1;
        while (j < n && i < n)
        {
            if (LMin[i] < RMax[j])
            {
                maxDiff = max(maxDiff, j - i);
                j = j + 1;
            }
            else
                i = i + 1;
        }

        return maxDiff;
    }
    /* Utility Functions to get max and minimum of two integers */
    static int max(int x, int y)
    {
        return x > y ? x : y;
    }

    static int min(int x, int y)
    {
        return x < y ? x : y;
    }
}

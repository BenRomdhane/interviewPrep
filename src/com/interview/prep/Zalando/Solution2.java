package com.interview.prep.Zalando;

/**
 * Created by Nikitash Pawar on 6/29/2017.
 */
public class Solution2 {

    public static void main(String[] args) {

    }

    public int solution(int[] T) {
        // write your code in Java SE 8

        int[] array1 = T, pos, hc;
        int positive = 0, negative = 0;

        // Check how many positive and/or negative numbers
        for (int i : array1)
        {
            if (i >= 0)
            {
                positive++;
            } else
            {
                negative++;
            }
        }

        // Make exact size arrays
        pos = new int[positive];
        hc = new int[negative];

        // Reset variables for new purpose
        positive = 0;
        negative = 0;

        //Put numbers in correct array
        for (int i : array1)
        {
            if (i >= 0)
            {
                pos[positive] = i;
                positive++;
            } else
            {
                hc[negative] = i;
                negative++;
            }
        }

        // Display arrays
        System.out.print("Starter array: ");
        for (int i: array1)
        {
            System.out.print(" " + i);
        }

        int count=0;
        System.out.print("\nPositive array: ");
        for (int i: pos)
        {
            System.out.print(" " + i);
            count++;
        }

        System.out.print("\nNegative array: ");
        for (int i: hc)
        {
            System.out.print(" " + i);
        }
        return T.length-count;
    }


}


package com.interview.prep.array;

/**
 * Created by Nikitash Pawar on 5/4/2017.
 */
public class FirstNonRepeatingChar {


    public static void main(String[] args) {

        char[] input={'a','a','b','d','d','c','d','d','d'};
        int[] tracker=new int[256];
        int current=' ';

        for(char val : input)
        {
            tracker[val]++;
            if(tracker[val]==1)
            {
                current=val;
            }

        }

        System.out.println((char)current);

    }
}

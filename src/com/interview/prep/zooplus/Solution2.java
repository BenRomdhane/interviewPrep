package com.interview.prep.zooplus;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nikitash Pawar on 6/26/2017.
 */
public class Solution2 {

    public static void main(String[] args) {

        int[] A=new int[8];
        A[0] = 7;
        A[1] = 3;
        A[2] = 7;
        A[3] = 3;
        A[4] = 1;
        A[5] = 3;
        A[6] = 4;
        A[7] = 1;
        System.out.println(solutionZ(A));

    }

    public static int solutionZ(int[] A) {
        // write your code in Java SE 8

        if(A==null || A.length==0){
            return 0;
        }

        Set<Integer> locations=new HashSet<Integer>();

        for (int i = 0; i < A.length; i++) {
            locations.add(A[i]);
        }
        Set<Integer> values=new HashSet<Integer>();
        int counter=0;
        int prevCounter=0;
        boolean first=false;
        int i;
        for (i = 0; i < A.length; i++) {

            if(values.add(A[i])==false && first==false){
                counter=i;
                first=true;
            }
            if(values.size()==locations.size())
            {
                break;
            }
        }
        return (i-counter)+1;
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8

        Set locations=new HashSet();

        for (int i = 0; i < A.length; i++) {
            locations.add(A[i]);
        }
        Set values=new HashSet();
        int counter=0;
        int prevCounter=0;
        for (int i = 0; i < A.length; i++) {

            values=new HashSet();
            counter=0;
            for (int j = i; j < A.length; j++) {

                    counter++;
                    values.add(A[j]);
                    if(values.size()==locations.size())
                    {
                        break;
                    }


            }
            if((prevCounter==0 || prevCounter> counter) && (values.size()==locations.size())){
                prevCounter=counter;
            }


        }
        return prevCounter;
    }
}

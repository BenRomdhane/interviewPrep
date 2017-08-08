package com.interview.prep.Zalando;

import java.util.ArrayList;
import java.util.HashSet;

import java.util.Set;

/**
 * Created by Nikitash Pawar on 7/8/2017.
 */
public class Solution3 {

    public static void main(String[] args) {


        int[] A={60,80,40};
        int[] B={2,3,5};
        int M=5;
        int X=2;
        int Y=200;
        System.out.println(solution(A,  B, M,  X,  Y) );
        A=new int[5];
        B=new int[5];
        M=3;
        X=5;
        Y=200;
        A[0] =  40;
        A[1] =  40;
        A[2] = 100;
        A[3] =  80;
        A[4] =  20;

        B[0] = 3;
        B[1] = 3;
        B[2] = 2;
        B[3] = 2;
        B[4] = 3;
        System.out.println(solution(A,  B, M,  X,  Y) );
    }


    public static int solution(int[] A, int[] B, int M, int X, int Y) {
        // write your code in Java SE 8

        int index=0;
        int currCapacity=0;
        int currWeight=0;
        Set floorsVisited=new HashSet();
        int actualCount=0;
        int retunToGround=0;
        while(index<A.length){

            if(currCapacity+1<=X && currWeight+A[index]<=Y){
                currCapacity++;
                currWeight+=A[index];
                floorsVisited.add(B[index]);
                index++;

            }else{
                currCapacity=0;
                currWeight=0;
                retunToGround++;
                actualCount+=floorsVisited.size();
                floorsVisited=new HashSet();
            }
        }
        retunToGround++;
        actualCount+=floorsVisited.size();
        return actualCount+retunToGround;
    }

}
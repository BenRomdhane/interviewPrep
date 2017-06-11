package com.interview.prep.fiveTran;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Nikitash Pawar on 5/28/2017.
 */
public class Solution {

    public static void main(String[] args) {



        //int[] height={8,1,2,3,4,8,7,6,5};
        int[] height={1,2,1,2,10,9};
        int[] val[];
        System.out.println(getMinimumMoves(height));
        LinkedList v=new LinkedList();
        HashMap obj=new HashMap();
        obj.put("d","K");;



        System.out.println();

        try{
            System.out.println("");


        }finally {

        }
    }




    static int getMinimumMoves(int[] height) {
    int moves=0;

        int leftVillTail=0;
        int rightVillTail=height.length-1;
    boolean toggleLeft=true;


    while (leftVillTail!=rightVillTail){
        if(toggleLeft){

            if(height[leftVillTail]<height[leftVillTail+1]){

            }else{
                toggleLeft=false;
                moves++;
            }
            leftVillTail++;

        }else {

            if(height[rightVillTail-1]>height[rightVillTail]){

            }else if(height[rightVillTail-1]<=height[rightVillTail]){
                toggleLeft=true;
                moves++;
            }
            rightVillTail--;
        }


    }


    return moves;

    }
}

package com.interview.prep.array;

/**
 * Created by Nikitash Pawar on 4/30/2017.
 */
public class MaxDiffBetnTwo {

    public static void main(String[] args) {

        int[] prices={2, 3, 10, 6, 4, 8, 1};
        int currMin=Integer.MAX_VALUE;
        int maxProfit=0;
        for (int val:prices) {

            if(currMin > val){
                currMin=val;
            }else {
                maxProfit=Math.max(maxProfit,val-currMin);
            }

        }
        System.out.println(maxProfit);

    }
}

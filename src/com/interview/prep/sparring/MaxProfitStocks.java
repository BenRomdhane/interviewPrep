package com.interview.prep.sparring;

/**
 * Created by Nikitash Pawar on 5/10/2017.
 */
public class MaxProfitStocks {

    public static void main(String[] args) {
        int[] input={300,50,40,30,90,170,100,200};
        System.out.println(maxDiff(input));
    }

    public static int maxDiff(int[] input)
    {
        int i=0;
        int j=i+1;
        int lp=input[i];
        int plp=lp;
        int mp=input[j];
        int diff=0;
        while(j!=input.length){
            //lp=input[i];
            mp=input[j];
            lp=Integer.min(lp,input[i]);
            diff=Integer.max(diff,mp-lp);
            System.out.println("lp :"+lp);
            System.out.println("mp :"+mp);
            //plp=lp;
            i++;
            j=i+1;
        }

        return diff;

    }
}

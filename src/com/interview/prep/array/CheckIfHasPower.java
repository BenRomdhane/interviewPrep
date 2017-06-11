package com.interview.prep.array;

/**
 * Created by Nikitash Pawar on 5/21/2017.
 */
public class CheckIfHasPower {

    public static void main(String[] args) {

        int input=81;
        int p;

        for(int i=2; i <= Math.sqrt(input);i++){
            p=i;
            while(p<=input){
                p*=i;
                if(p==input){
                    System.out.println(true);
                    break;
                }
            }
        }
    }
}

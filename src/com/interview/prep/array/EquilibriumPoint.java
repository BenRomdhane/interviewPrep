package com.interview.prep.array;

/**
 * Created by Nikitash Pawar on 5/17/2017.
 */
public class EquilibriumPoint {

    public static void main(String[] args) {

        int[] input={7,1,1,4,3,1};
        int head=0;

        int tail=input.length-1;
        int sumFromHead=input[0];
        int sumFromTail=input[tail];
        head++;
        tail--;


        while(head!=tail ){


            if(sumFromHead>sumFromTail){
                sumFromTail+=input[tail];
                tail--;

            }else {
                sumFromHead+=input[head];
                head++;

            }
        }


        if(sumFromHead==sumFromTail ){
            System.out.println(head);
        }else {
            System.out.println("NO");
        }

    }
}

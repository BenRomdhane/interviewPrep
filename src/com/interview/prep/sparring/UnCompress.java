package com.interview.prep.sparring;

import java.util.Arrays;

/**
 * Created by Nikitash Pawar on 5/12/2017.
 */
public class UnCompress {


    /**
     * on encounter digit-mark as the number of times
     * need to move right.
     * start moving all items from end of the array towards right
     * by the number identified above.
     * populate all the newly added places with values
     *
     * @param args
     */
    public static void main(String[] args) {

        char prev;
        char[] input=new char[100];
        Arrays.fill(input,' ');
        input[0]='a';
        input[1]='3';
        input[2]='b';
        input[3]='2';
        int moveBy=0;

        System.out.println(new String(input));
        for (int i = 0; i < input.length; i++) {
            if (Character.isDigit(input[i])){
                //ident the amount of right movements
                moveBy=Character.digit(input[i],10);
                //starting right most element start moving them to right
                input=shiftArrayToRightBy(input,i,moveBy-2);
                int endIndex=i+moveBy-1;
                //fill the spaces with the previos most char
                Arrays.fill(input,i,endIndex,input[i-1]);
            }
            else if(input[i]==' ') break;
        }
        System.out.println(new String(input));
    }

    private static char[] shiftArrayToRightBy(char[] input, int currentIndex, int digit) {


        int lastIndex=0;
        for (lastIndex = input.length-1; lastIndex >=0 ; lastIndex--) {
            if(input[lastIndex]!=' '){
                break;
            }

        }

            for (int i = lastIndex; i >=currentIndex ; i--) {
                input[i+digit]=input[i];
                input[i]=' ';
            }

        return input;
    }
}

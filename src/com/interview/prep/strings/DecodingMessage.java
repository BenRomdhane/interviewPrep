package com.interview.prep.strings;

/**
 * Created by Nikitash Pawar on 5/21/2017.
 */
public class DecodingMessage {

    public static void main(String[] args) {


        String input="2563";
        char[] values=input.toCharArray();
        int possibleValues=1;
        for(int i=0;i<=values.length-2;i++){

            if(Integer.valueOf(String.valueOf(values[i])+String.valueOf(values[i+1])) <= 26)
            {
                possibleValues++;
            }
        }
        System.out.println(possibleValues);
    }
}

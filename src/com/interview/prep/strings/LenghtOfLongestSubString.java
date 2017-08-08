package com.interview.prep.strings;

/**
 * Created by Nikitash Pawar on 7/29/2017.
 */
public class LenghtOfLongestSubString {


    public static void main(String[] args) {

        System.out.println(solution("eceba”"));
    }

    public static String solution(String input){

        String prevMax="";
        String currMax="";


        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            currMax+=chars[i];
            if(((currMax.split(String.valueOf(chars[i]))).length)>=2){
                    if(currMax.length()>prevMax.length()){
                        prevMax=currMax;
                    }
                    currMax="";
            }

        }


        return prevMax;
    }

}



package com.interview.prep.strings;

import java.util.Arrays;

/**
 * Created by Nikitash Pawar on 4/27/2017.
 */
public class LongestSubSeqWithNoRepeteChar {

    public static void main(String[] args) {
        System.out.println(lenghtOfLongestSubstring("xbcadbjcak"));
    }

    public static int lenghtOfLongestSubstring(String inputString){
        char[] charMap=new char[256];
        int counter=0;
        String subSequence="";
        String largestSubSequence="";
        boolean hit;
        char currentChar;
        while(counter!=inputString.length()){
            currentChar=inputString.charAt(counter);

            if(charMap[currentChar]>0){
                hit=true;
            }else{
                hit=false;
            }
            charMap[currentChar]++;
            if(hit){
                subSequence+=String.valueOf(currentChar);
            }else{
                if(subSequence.length() >= largestSubSequence.length()){
                    largestSubSequence=subSequence;
                }
                subSequence="";
            }
            counter++;
        }
        return largestSubSequence.length();
    }
}

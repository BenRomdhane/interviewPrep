package com.interview.prep.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nikitash Pawar on 8/6/2017.
 */
public class LongestDistinctCharInString {

    public static void main(String[] args) {
        String input="geeksForGeeks";
        System.out.println(solution(input));
    }

    private static int solution(String input) {

        //set to maintain all char encountered
        Set<Character> alreadyEncountered=new HashSet<>();

        //counter to maintain the count
        int counter=0;
        int prevMax=0;
        char[] inputChars = (input.toLowerCase()).toCharArray();

        for (Character ch:inputChars) {
            if(alreadyEncountered.contains(ch)){
                prevMax=Math.max(prevMax,counter);
                counter=1;
            }else {
                counter++;
                alreadyEncountered.add(ch);
            }
        }
        return prevMax;
    }
}

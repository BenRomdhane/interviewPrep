package com.interview.prep.strings;

/**
 * Created by Nikitash Pawar on 8/6/2017.
 */
public class FindAndReverSubSeq {

    public static void main(String[] args) {

        String input="This is a Test";
        String patt="is";
        System.out.println(solution(input,patt));
    }

    private static String solution(String input, String patt) {

        if ((input.split(patt)).length==0){
            return input;
        }

        StringBuilder stringBuilder = new StringBuilder(patt);

        String output = input.replaceAll(patt, (stringBuilder.reverse()).toString());

        return output;
    }
}

package com.interview.prep.strings;

/**
 * Created by Nikitash Pawar on 11/20/2016.
 */
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
        System.out.println(compressString("abcd"));
        System.out.println(compressString("aabbcc"));
    }

    private static String compressString(String s) {

        String so=s;
        String sm="";
        char prevChar=s.toCharArray()[0];
        int count=0;

        for (char cc: s.toCharArray()) {
            if(prevChar!=cc)
            {
                sm+=createString(prevChar,count);
                count=1;
                prevChar=cc;
            }
            else {
                count++;
            }
        }

        sm+=createString(prevChar,count);

        if(so.length() >= sm.length()){
            return sm;
        }else {
            return so;
        }
    }

    private static String createString(char prevChar, int count) {

        return String.valueOf(prevChar)+String.valueOf(count);
    }
}

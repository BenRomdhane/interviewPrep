package com.interview.prep.strings;

/**
 * Created by Nikitash Pawar on 11/20/2016.
 */
public class URLify {
    public static void main(String[] args) {

        String s="Mr. John Smith  ";
        System.out.println(urlify(s));
    }

    private static String urlify(String s) {
        return (s.trim()).replace(" ","%20");
    }
}

package com.interview.prep.strings;

/**
 * Created by Nikitash Pawar on 11/20/2016.
 */
public class PermutationString {

    public static void main(String[] args) {
        String s1="abcd";
        String s2="abcd";
        System.out.println(permutationOfEachOther(s1,s2));
    }

    private static boolean permutationOfEachOther(String s1, String s2) {
        if((s1.length()==s2.length()) && (asciiSum(s1)==asciiSum(s2)))
        {
            return true;
        }
        return false;
    }

    private static int asciiSum(String s1) {
        int sum=0;
        for (char c: s1.toCharArray()) {
            sum+=c;
        }
        return sum;
    }
}

package com.interview.prep.arrayandstrings;

/**
 * Created by Nikitash Pawar on 11/20/2016.
 */
public class PermutationOfPallindromeUsingBitVector {

    public static void main(String[] args) {
        String s="Tact Coa";
        System.out.println(isPermutationOfPallindrome(s));
    }

    private static boolean isPermutationOfPallindrome(String s) {
        int checker=0;
        int index=0;
        s=(s.toLowerCase()).replace(" ","");
        for (char c:s.toCharArray()) {
            index = (c-'a');
            if((checker & index)==0) {
                checker=checker|index;
            }
            else {
                checker=checker & ~index;
            }
        }
        return (checker & (checker-1))==0;
    }
}

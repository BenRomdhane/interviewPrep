package com.interview.prep.arrayandstrings;

/**
 * Created by Nikitash Pawar on 11/20/2016.
 */
public class PermutationOfPallindrome {

    public static void main(String[] args) {
        String s="abba";
        System.out.println(isPermutationOfPallindrome(s));
    }

    private static boolean isPermutationOfPallindrome(String s) {
        int countEven = 0;
        int countOdd = 0;
        s=(s.toLowerCase()).replace(" ","");
        System.out.println(s);
        int [] table= new int[128];
        for (char c:s.toCharArray()) {
            table[c]++;
            if(table[c] % 2 ==0)
            {
                countEven++;
            }
        }
        int numberOfCharsOccuredOnce = s.length() - (countEven * 2);
        return ((numberOfCharsOccuredOnce ==1)||(numberOfCharsOccuredOnce ==0));
    }
}

package com.interview.prep.strings;

/**
 * Created by Nikitash Pawar on 11/20/2016.
 */
public class PermutationOfPallindrome {

    public static void main(String[] args) {
        String s="abba";
        System.out.println(isPermutationOfPallindrome(s));
    }

    /**
     * if permutation of a pallindrome then
     * every char must occur twice while one char
     * can occur once. we keep count of every char in a table.
     * if char occurs twice we increment a countEven counter
     * and then in the end multiply it by 2 and substract from
     * main string lenght. if the value after subs is 1 or zero then ret true
     * else false.
     * @param s
     * @return
     */
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

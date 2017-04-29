package com.interview.prep.bitvector;

import java.util.HashSet;
import java.util.Set;

public class UniqueElementsInArrayUsingBitVector {

    public static void main(String[] args) {
	// all elements of the array are unique
        String s1 ="abcde";
        String s2 ="abcda";

        System.out.println(hasAllUniqueChars(s1.toCharArray()));
        System.out.println(hasAllUniqueChars(s2.toCharArray()));

    }

    private static boolean hasAllUniqueChars(char[] chars) {
       if (chars.length>128) return false;

        int checker=0;

        for (int i=0; i < chars.length;i++)
        {
            int val= chars[i]-'a';
            if((checker & (1 << val)) >0)
            {
                return false;
            }
            checker= checker | val;
        }
        return true;
    }
}

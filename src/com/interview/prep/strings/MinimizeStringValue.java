package com.interview.prep.strings;

/**
 * Created by Nikitash Pawar on 5/17/2017.
 */
public class MinimizeStringValue {

    /**
     * Given a string of lowercase alphabets and a number k,
     * the task is to print the minimum value of the string
     * after removal of ‘k’ characters.  The value of a string
     * is defined as sum of squares of count of each distinct
     * character. For example consider the string “saideep”, here
     * frequencies of characters are s-1, a-1, i-1,e-2, d-1, p-1 and
     * value of the string is 1^2 + 1^2 + 1^2 + 1^2 + 1^1 + 2^2 = 9.
     * @param args
     */
    public static void main(String[] args) {

        String input="abccc";
        int kChars=1;
        int[] counter=new int[100];
        char max=Character.MIN_VALUE;
        int output = 0;

        for (char c:input.toCharArray()) {
            if((int)c > (int)max){
                max=c;
            }

            counter[c]++;
        }

        while (kChars!=0){
            counter[max]--;
            kChars--;
        }

        char prevChar=Character.MIN_VALUE;
        for (char c:input.toCharArray()) {
            if(c==prevChar){
                continue;
            }
            output+=Math.pow(counter[c],2);
            prevChar=c;
        }
        System.out.println(output);
    }
}

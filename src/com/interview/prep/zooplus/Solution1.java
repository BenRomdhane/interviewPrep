package com.interview.prep.zooplus;

/**
 * Created by Nikitash Pawar on 6/26/2017.
 */
public class Solution1 {

    public static void main(String[] args) {

        System.out.println(solution("00-44  48 5555 8361"));
        System.out.println(solution("555372654"));
    }


    public static String solution(String S) {
        // write your code in Java SE 8

        S=S.replaceAll("\\s","");
        S=S.replaceAll("-","");
        StringBuilder finalString=new StringBuilder();
        if(S.length()%2==0){

            char[] values = S.toCharArray();
            finalString.append(values[0]);
            for (int i = 1; i < values.length-2; i++) {

                if(i%3==0) {
                    finalString.append('-');
                }
                finalString.append(values[i]);
            }
            finalString.append('-');
            finalString.append(values[values.length-2]);
            finalString.append(values[values.length-1]);

        }else
        {
            char[] values = S.toCharArray();
            finalString.append(values[0]);
            for (int i = 1; i < values.length-2; i++) {

                if(i%3==0) {
                    finalString.append('-');
                }
                finalString.append(values[i]);
            }


            finalString.append(values[values.length-2]);
            finalString.append(values[values.length-1]);
        }
        return finalString.toString();
    }
}

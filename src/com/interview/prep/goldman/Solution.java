package com.interview.prep.goldman;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikitash Pawar on 5/27/2017.
 */
public class Solution {

    public static void main(String[] args) {
        //System.out.println("Hi");
        //collapseString("AAABBBC");
        calculatePossibleCombinations("2112");
        calculatePossibleCombinations("2101");
    }

/*    private static long calculatePossibleCombinations(String input) {

        char[] values = input.toCharArray();
        int head=0;
        Map<String,String> data=new HashMap<>();
        int tail=values.length;

        while (head!=tail){

        }

        return 0;
    }*/

    static long calculatePossibleCombinations(String input) {

        if(input.length()<1 ){
            return 0;
        }
        if (Long.valueOf(input)==0){
            return 0;
        }
        long count=0;
        char[] values = input.toCharArray();

        for (int i = 0; i < values.length; i++) {
            for (int j = i+1; j < values.length; j++) {
                String newVal=input.substring(i, j);
                String rest=input.substring(j, values.length);
                Long currVal = Long.valueOf(newVal.toString());
                if(currVal >0 && currVal < 27 && !rest.startsWith("0")){
                    //System.out.println(newVal.toString());
                    count++;
                }
            }
            //System.out.println("---------");
        }

        int zeroOcc=input.length() - input.replace("0", "").length();

        System.out.println(count-zeroOcc);

        return count;
    }

   /* static String collapseString(String input) {
        char[] values = input.toCharArray();
        char prev=values[0];
        int count=1;
        StringBuilder builder=new StringBuilder();
        for (int i = 1; i < values.length; i++) {
            if(values[i]==prev){
                count++;
            }else {
                builder.append(count);
                builder.append(prev);
                count=1;
            }
            prev=values[i];
        }
        builder.append(count);
        builder.append(prev);
        System.out.println(builder.toString());

        return builder.toString();
    }*/

}

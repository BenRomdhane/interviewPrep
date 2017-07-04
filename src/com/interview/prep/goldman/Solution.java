package com.interview.prep.goldman;

import javax.print.DocFlavor;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Nikitash Pawar on 5/27/2017.
 */
public class Solution {

    public static void main(String[] args) {
        //System.out.println("Hi");
        //collapseString("AAABBBC");
        calculatePossibleCombinations("2101");
        calculatePossibleCombinations("2112");
       // calculatePossibleCombinationsNew("2101");
    }





    static long calculatePossibleCombinationsNew(String input)
    {
        if(input.length()<1 ){
            return 0;
        }
        if (Long.valueOf(input)==0){
            return 0;
        }
        long count=0;
        char[] values = input.toCharArray();
        Set<String> uniqStr=new HashSet<>();
        for (int i = 0; i < values.length; i++) {
            for (int j = i+1; j < values.length; j++) {
                String newVal=input.substring(i, j);
                String rest=input.substring(j, values.length);
                Long currVal = Long.valueOf(newVal.toString());
                if(currVal >0 && currVal < 27 && !rest.startsWith("0")){

                    String s=new String(newVal);
                    count++;
                }
            }
            //System.out.println("---------");
        }

        return 0;
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


        try {

            if (new BigDecimal(input).compareTo(BigDecimal.ZERO) == 0){
                return 0;
            }
        }catch (NumberFormatException e) {
            return 0;
        }


        long count=0;
        char[] values = input.toCharArray();

        for (int i = 0; i < values.length; i++) {
            for (int j = i+1; j < values.length; j++) {
                String newVal=input.substring(i, j);
                String rest=input.substring(j, values.length);
                Long currVal;
                Long restVal;
                try{
                     currVal = Long.valueOf(newVal);
                     restVal = Long.valueOf(rest);
                }catch (Exception e){
                    continue;
                }

                //System.out.println(currVal+" "+rest);
                if(isValid(currVal) && isValid(restVal) && !rest.startsWith("0")){
                    //System.out.println(newVal.toString());
                    count++;
                    //System.out.println(currVal+" "+rest);

                }
            }
            //System.out.println("---------");
        }

        count++;
        int zeroOcc=input.length() - input.replace("0", "").length();

        //System.out.println(count-zeroOcc);
        count=count-zeroOcc;
        System.out.println(count);
        return count;

    }

    private static boolean isValid(Long currVal) {
        return currVal > 0 && currVal < 27;
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

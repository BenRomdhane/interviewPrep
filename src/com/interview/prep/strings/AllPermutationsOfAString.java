package com.interview.prep.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nikitash Pawar on 5/14/2017.
 */
public class AllPermutationsOfAString {

    static Set<String> values=new HashSet<>();

    public static void main(String[] args) {

        String input="ABCD";


        int head=0;
        int tail=input.length();

        while(head!=tail)
        {
            swapStartingFromHead(input,head);
            head++;
        }

        System.out.println(values.size());
        //permute(input,0,input.length()-1);

    }

    private static void swapStartingFromHead(String input, int head) {

        for (int i = head; i < input.length(); i++) {
            String swapped = swap(input, head, i);
            rotate(swapped);
        }
    }

    private static void rotate(String swapped) {

        for (int i = 0; i < swapped.length(); i++) {
        swapped=swapped.substring(1,swapped.length())+swapped.substring(0,1);
           // System.out.println(swapped);
            values.add(swapped);
        }
    }

    private static void permute(String input, int left, int right) {
        
        if(left==right){
            System.out.println(input);
        }else{
            for (int i = left; i <=right ; i++) {
                input=swap(input,left,i);
                System.out.println("SWP1:"+input);
                permute(input,left+1,right);
                input=swap(input,left,i);
                System.out.println("SWP2:"+input);
            }
        }


        
    }

    private static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }


}

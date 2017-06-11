package com.interview.prep.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Nikitash Pawar on 5/21/2017.
 */
public class CreateLargestNumber {


    public static void main(String[] args) {


        int[] input={3, 30, 34, 5 , 9};

        String s = largestNumber(input);
        System.out.println(s);
    }

    public static String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i]=String.valueOf(nums[i]);
        }

        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String s: arr){
            sb.append(s);
        }

        while(sb.charAt(0)=='0'&&sb.length()>1)
            sb.deleteCharAt(0);

        return sb.toString();
    }

}

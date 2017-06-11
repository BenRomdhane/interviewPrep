package com.interview.prep.strings;

/**
 * Created by Nikitash Pawar on 5/21/2017.
 */
public class LargestPallindromeSubstring {

    public static void main(String[] args) {

        String input="aaaabbaa";    

        char[] value=input.toCharArray();
        int pointLeft;
        int pointRight;
        boolean toggle = false;
        int start = 0;
        int end = 0;
        for(int i=0;i<value.length;i++){

            pointLeft=i;
            pointRight=value.length-1;
            toggle=false;

            while(pointLeft<pointRight){

                if(value[pointLeft]==value[pointRight]){
                    if(toggle==false){
                        start=pointLeft;
                        end=pointRight;
                        toggle=true;
                    }
                    if(pointRight-pointLeft==1){
                        System.out.println(start+", "+end);
                    }

                    pointLeft++;
                    pointRight--;
                }else{
                    pointRight--;
                    pointLeft=i;
                    toggle=false;
                }

            }

        }

    }
}

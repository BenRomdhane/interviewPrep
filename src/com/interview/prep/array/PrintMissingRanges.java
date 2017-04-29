package com.interview.prep.array;

/**
 * Created by Nikitash Pawar on 4/27/2017.
 */
public class PrintMissingRanges {
    public static void main(String[] args) {

        String[] missingRanges = findMissingRanges(new int[]{0, 1, 3, 50, 75});
        for (String s:missingRanges ) {
            System.out.println(s);
        }

    }

    static String[] findMissingRanges(int[] values){

        String[] ranges=new String[values.length];
        int counterForRanges=0;
        int previous=values[0];
        int current=values[1];

        for(int i=1;i < values.length;i++){

            if(values[i-1]!=(values[i]-1)){
                if((values[i-1]+1)==(values[i]-1)){
                    ranges[counterForRanges]=String.valueOf(values[i-1]+1);
                }else{
                    ranges[counterForRanges]=String.valueOf(values[i-1]+1)+"->"+String.valueOf(values[i]-1);
                }

                counterForRanges++;
            }

            if(i==values.length-1){
                if(values[i]!=99){
                    ranges[counterForRanges]=String.valueOf(values[i]+1)+"->"+String.valueOf(99);
                }
            }
        }
        return ranges;
    }
}

package com.interview.prep.array;

/**
 * Created by Nikitash Pawar on 5/13/2017.
 */
public class SubArrayWithGivenSum {

    private static int tempSum;
    private static int maxSum=12;

    public static void main(String[] args) {

        int[] a={1, 2 ,3 ,7 ,5};

        for (int i = 0; i < a.length; i++) {

            tempSum=0;
            for (int j = i; j < a.length; j++) {
                tempSum+=a[j];
                if(tempSum==maxSum){
                    System.out.println(i+" "+j);
                    break;
                }else if(tempSum > maxSum){
                    break;
                }
            }

        }
    }
}

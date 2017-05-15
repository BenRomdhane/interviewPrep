package com.interview.prep.array;

/**
 * Created by Nikitash Pawar on 5/13/2017.
 */
public class SubSetSum {

    private static int sum;

    public static void main(String[] args) {

        //int[] a={1, 5, 11, 5};
        int[] a={1, 2, 5, 20};
        int[] values=new int[100];

        for (int i = 0; i < a.length; i++) {
            sum=0;

            for(int j = i; j < a.length; j++) {
                sum+=a[j];
                if(values[sum]!=1){
                    values[sum]=1;
                }else {
                    System.out.println("YES");
                    System.out.println(sum);
                }
                //System.out.println(sum);
            }
        }

    }
}

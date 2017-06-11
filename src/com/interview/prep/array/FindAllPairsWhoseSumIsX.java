package com.interview.prep.array;

/**
 * Created by Nikitash Pawar on 5/21/2017.
 */
public class FindAllPairsWhoseSumIsX {

    public static void main(String[] args) {

        int[] a={1,2,4,5,7};
        int[] b={3,4,5,6,8};
        int sum=9;
        int currSum=0;
        int pointA=0;
        int pointB=b.length-1;

        while(pointA < a.length && pointB > 0)
        {
            currSum=a[pointA]+b[pointB];

            if(currSum==sum){
                System.out.println(a[pointA]+","+b[pointB]);
                pointA++;
                pointB--;
            }else if(currSum < sum){
                pointA++;
            }else{
                pointB--;
            }
        }
    }
}

package com.interview.prep.array;

/**
 * Created by Nikitash Pawar on 4/27/2017.
 */
public class PallindromeNumber {

    public static void main(String[] args) {
        System.out.println(returnPallindrome(121121));
    }

    static int returnPallindrome(int input){

        int inputCopy=input,inputCopy1=input,inputCopy2=input;
        int counter=0;
        while(inputCopy/10!=0)
        {
            inputCopy=inputCopy/10;
            counter++;
        }

        int highestTens=counter;
        int numberOfIterations=(counter+1)/2;
        int remainder1;
        int remainder2;
        while(numberOfIterations!=0){

            remainder1=(inputCopy1/((int)Math.pow(10,highestTens)));
            remainder2=(inputCopy2%10);
            if(remainder1!=remainder2){
                return 0;
            }
            inputCopy1=inputCopy1%((int)Math.pow(10,highestTens));
            inputCopy2=(inputCopy2/10);
            highestTens--;
            numberOfIterations--;
        }
        return input;
    }
}

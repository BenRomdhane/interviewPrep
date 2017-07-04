package com.interview.prep.mobileiron;

/**
 * Created by Nikitash Pawar on 6/14/2017.
 */
public class Solution2 {

    public static void main(String[] args) {

        String[] a=new String[1];
        a[0]="av";
        String[] b=new String[1];
        b[0]="ab";
        twins(a,b);

        /*String[] a=new String[2];
        a[0]="cdab";
        a[1]="dcab";
        String[] b=new String[2];
        b[0]="abcd";
        b[1]="abcd";
        twins(a,b);*/

    }

    static String[] twins(String[] a, String[] b) {

        String[] out=new String[a.length];

        for (int i = 0; i < a.length; i++) {
            char[] charA = a[i].toCharArray();
            char[] charB = b[i].toCharArray();
            for (int j = 0; j < charA.length; j++) {
                for (int k = j+2; k <charA.length ; k=k+2) {

                    if(charA[j]!=charB[k]){
                        out[i]="No";

                    }
                    if(charA[j]==charB[k-2]){
                        out[i]="Yes";
                    }

                    if(out[i]=="No"){
                        break;
                    }
                    out[i]="Yes";
                }
            }

        }

        if(out.length==0){
            out[0]="No";
        }

        return out;
    }
}

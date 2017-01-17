package com.interview.prep.arrayandstrings;

/**
 * Created by Nikitash Pawar on 11/20/2016.
 */
public class AddRemReplCharInString {
    public static void main(String[] args) {

        System.out.println(manipulationPossible("pale","ple"));
        System.out.println(manipulationPossible("pales","pale"));
        System.out.println(manipulationPossible("pale","bale"));
        System.out.println(manipulationPossible("pale","bake"));
    }

    private static boolean manipulationPossible(String s1, String s2) {

        int lenght=0;

        if(s1.length()>s2.length()){
            lenght=s2.length();
        }else{
            lenght=s1.length();
        }

        int[] s1T= new int[128];
        int[] s2T= new int[128];

        s1T =loadTable(s1);
        s2T =loadTable(s2);
        int occurance=0;

        for(int i=0;i<lenght;i++)
        {
        occurance += (s1T[s1.toCharArray()[i]] - s2T[s1.toCharArray()[i]]);

            if(occurance < -1)
            {
                return false;
            }
            else if(occurance > 1)
            {
                return false;
            }
        }

        return true;
    }

    private static int[] loadTable(String s) {
        int[] sT= new int[128];
        for (char c: s.toCharArray()) {
            sT[c]++;
        }
        return sT;
    }
}

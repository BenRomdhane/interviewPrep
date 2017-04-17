package com.interview.prep.arrayandstrings;

import java.util.Arrays;

/**
 * Created by Nikitash Pawar on 4/12/2017.
 */
public class StringSubSequence {


    private static int[][] lcsTable;

    public static void main(String[] args) {
        //lcsTable=computeLcsTable("CATCGA","GTACCGTCA");
        lcsTable=computeLcsTable("CAT","CATTLE");

    }

    private static int[][] computeLcsTable(String s1, String s2) {
        int table[][]=new int[s1.length()+1][s2.length()+1];
        //Arrays.fill(table,0);
        for (int row = 1; row <s1.length()+1 ; row++) {
            {
                for (int column = 1; column <s2.length()+1 ; column++) {
                    if(s1.toCharArray()[row-1]==s2.toCharArray()[column-1]){
                        System.out.print("from S1 :"+s1.toCharArray()[row-1]);
                        System.out.println(" from S2 :"+s2.toCharArray()[column-1]);
                        table[row][column]=table[row-1][column-1]+1;
                        System.out.println("Incrementing count to: "+table[row][column]);
                    }else{
                        System.out.print("from S1 :"+s1.toCharArray()[row-1]);
                        System.out.println(" from S2 :"+s2.toCharArray()[column-1]);
                        table[row][column]=Integer.max(table[row][column-1],table[row-1][column]);
                        System.out.println("setting count to: "+table[row][column]);
                    }
                }
            }
        }

        for (int row = 0; row <s1.length()+1 ; row++) {
            {
                for (int column = 0; column <s2.length()+1 ; column++) {
                    System.out.print(table[row][column]);
                    }
                System.out.println();
            }

        }

        String lcs="";
        lcs=lcs+assembleLcs(s1,s2,table,s1.length(),s2.length());
        System.out.println(lcs);
        return table;
    }

    private static String assembleLcs(String s1, String s2, int[][] table, int row, int column) {
            if(table[row][column]==0){
                return "";
            }else if(s1.toCharArray()[row-1]==s2.toCharArray()[column-1]){
                return s1.toCharArray()[row-1]+assembleLcs(s1,s2,table,row-1,column-1);
            }else if(table[row][column-1]>table[row-1][column]){
                return assembleLcs(s1,s2,table,row,column-1);
            }else if(table[row][column-1]<table[row-1][column]){
                return assembleLcs(s1,s2,table,row-1,column);
            }
        return "";
    }


}

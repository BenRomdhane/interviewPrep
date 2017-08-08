package com.interview.prep.Zalando;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Nikitash Pawar on 7/8/2017.
 */
public class Solution4 {

    public static void main(String[] args) {

        String S="1B 2C,2D 4D";
        String T="2B 2D 3D 4D 4A";
        int N=4;
        //(12, '1A 2A,12A 12A', '12A')
        System.out.println(solution(12, "1A 2A,12A 12A", "12A"));


        //System.out.println(solution(N, S, T) );

    }

    public static String solution(int N, String S, String T) {
        // write your code in Java SE 8


        String[] ships = S.split(",");
        List<List<String>> shipsVal= new ArrayList<>();

        for (int i = 0; i < ships.length; i++) {
            ships[i]= fullShip(ships[i]);
            System.out.println(ships[i]);
            List<String> strings = Arrays.asList(ships[i].split(","));
            shipsVal.add( strings);
        }


        List<String> hits = Arrays.asList(T.split(" "));

        int fullHit=0;
        int parHit=0;
        for (List<String> values:shipsVal) {

            if(hits.containsAll(values)){
                fullHit++;
            }else
            {
                for (String temp:values) {
                    if(hits.contains(temp)){
                        parHit++;
                    }
                }
            }

        }
        System.out.println("Hi");

        return fullHit+","+parHit;
    }

    private static String fullShip(String ship) {

        String[] split = ship.split(" ");

        if(split[0].equalsIgnoreCase(split[1]))
        {
            return split[0]+","+split[1];
        }
        int topRow=0;
        int topCol=0;
        int botRow=0;
        int botCol=0;

        for (int i = 0; i <split.length; i++) {

            char[] coOrds = split[i].toCharArray();
            for (int j = 0; j < coOrds.length; j++) {

                if(i==0 && j==0){
                    topRow=Character.getNumericValue(coOrds[j])-1;
                }else if(i==0 && j==1){
                    topCol=(int)(coOrds[j]-'A');
                }
                else if(i==1 && j==0){
                    botRow=Character.getNumericValue(coOrds[j]-1);
                }
                else if(i==1 && j==1){
                    botCol=(int)(coOrds[j]-'A');
                }
                //System.out.println(coOrds[j]);
            }
        }

        int tempTopRow=topRow;
        int tempTopCol=topCol;
        boolean square=false;
        while(tempTopRow<=botRow && tempTopCol<=botRow){
            tempTopCol++;
            tempTopRow++;
        }
        if(tempTopRow==botRow && tempTopCol==botCol){
            square=true;
        }
        String tempShip="";


            for (int i = topRow; i <= botRow; i++) {
                for (int j =topCol; j <= botCol; j++) {
                    tempShip+=(String.valueOf(i+1)+String.valueOf((char)(j+'A'))+",");
                }

            }
        return tempShip;
    }
}

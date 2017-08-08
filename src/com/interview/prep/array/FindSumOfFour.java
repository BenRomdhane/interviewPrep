package com.interview.prep.array;

import java.util.*;

/**
 * Created by Nikitash Pawar on 8/6/2017.
 */
public class FindSumOfFour {

    public static void main(String[] args) {

        int[] input={10, 2, 3, 4, 5, 9, 7, 8};
        int sum=23;

        Map<Integer,ArrayList<ArrayList<Integer>>> matrix=new HashMap<>();


        for (int i = 0; i < input.length; i++) {
            for (int j = i+1; j < input.length; j++) {
                int key=input[i]+input[j];
                ArrayList list=new ArrayList();
                list.add(input[i]);
                list.add(input[j]);
                if (matrix.containsKey(key)) {
                    matrix.get(key).add(list);
                } else {
                    ArrayList<ArrayList<Integer>> doubleList=new ArrayList<>();
                    doubleList.add(list);
                    matrix.put(key,doubleList);
                }
            }
        }

        Set<Map.Entry<Integer, ArrayList<ArrayList<Integer>>>> entries = matrix.entrySet();

        for ( Map.Entry<Integer, ArrayList<ArrayList<Integer>>> entry:entries) {

            ArrayList<ArrayList<Integer>> arrayLists = matrix.get(sum - entry.getKey());

            if (arrayLists!=null) {
                for (ArrayList<Integer> innerList:arrayLists) {
                    System.out.print(entry.getValue());
                    System.out.print(innerList);
                }
                System.out.println();
            }
        }

        /*for (int i = 0; i < input.length; i++) {
            for (int j = i+1; j < input.length; j++) {
                for (int k = j+1; k < input.length; k++) {
                    for (int l = k; l < input.length; l++) {
                        if((input[i]+input[j]+input[k]+input[l])==sum){
                            System.out.println(input[i]+","+input[j]+","+input[k]+","+input[l]);
                        }
                    }

                }
            }
        }*/
    }

}

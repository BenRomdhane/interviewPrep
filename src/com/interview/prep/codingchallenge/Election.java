package com.interview.prep.codingchallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Nikitash Pawar on 2/10/2017.
 */
public class Election {


    public static void main(String[] args) {
        BufferedReader br = null;
        int readCounter=-1;
        int numberOfLinesToRead=0;
        Map<Integer,Integer> map=new TreeMap<>();
        Set<Integer> elected=new HashSet<>();
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            while (readCounter < numberOfLinesToRead) {
                //System.out.print("Enter something : ");
                String input = br.readLine();
                if(readCounter==-1)
                {
                    List parsedLineSplit = convertToIntSet(input.split(" "));
                    numberOfLinesToRead=parsedLineSplit.size();
                }else {
                    addToMap(input.split(" "),map,elected);
                }
                readCounter++;
                //System.out.println("readCounter "+readCounter+" "+"numberOfLinesToRead "+ +numberOfLinesToRead);
            }
           // System.out.println(map.toString());
            System.out.println(elected.size());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static List convertToIntSet(String[] split) {
        List<Integer> set=new ArrayList<>();
        for (String value:split) {
            set.add(Integer.valueOf(value));
        }
        return set;
    }

    private static void addToMap(String[] split,Map<Integer,Integer> map,Set elected) {
        for (String value:split) {
            int temp=Integer.valueOf(value);
            if(map.containsKey(temp))
            {
                Integer temp1 = map.get(temp);
                temp1++;
                map.put(temp,temp1);
                if(temp1>=3)
                {
                elected.add(temp);
                }
            }else {
                map.put(temp,1);
            }
        }
    }

    private static Set convertToIntTreeSet(String[] split) {
        Set<Integer> set=new TreeSet<>();
        for (String value:split) {
            set.add(Integer.valueOf(value));
        }
        return set;
    }
}

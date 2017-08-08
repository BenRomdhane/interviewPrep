package com.interview.prep.collections;

import java.util.*;

/**
 * Created by Nikitash Pawar on 7/22/2017.
 */
public class ValueSortMap {

    public static void main(String[] args) {

        TreeMap<Integer,String> input=new TreeMap<Integer, String>();
        input.put(2,"B");
        input.put(1,"A");
        input.put(3,"C");
        input.put(5,"E");
        input.put(4,"D");
        input.put(6,"F");

        Set<Map.Entry<Integer, String>> entries = input.entrySet();

        ArrayList<Map.Entry<Integer, String>> list=new ArrayList<>(entries);

        Collections.sort(list, (o1, o2) -> (o1.getValue()).compareTo(o1.getValue()));

        System.out.println(list);

    }
}

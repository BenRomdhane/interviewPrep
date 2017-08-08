package com.interview.prep.collections;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by Nikitash Pawar on 7/23/2017.
 */
public class RangeLookUp {

    public static void main(String[] args) {

        NavigableMap<Integer,String> map=new TreeMap<>();
        map.put(10,"KA");
        map.put(20,"KA");
        map.put(30,"KA");
        map.put(40,"KA");

        System.out.println(map.floorKey(11));
        System.out.println(map.ceilingKey(11));

    }

}



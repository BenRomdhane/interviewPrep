package com.interview.prep.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikitash Pawar on 5/22/2017.
 */
public class CHashMap {

    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("s1","s1");
        map.put("s1","s2");
        System.out.println(map);
    }
}

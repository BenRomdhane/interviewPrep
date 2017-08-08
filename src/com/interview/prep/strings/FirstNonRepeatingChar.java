package com.interview.prep.strings;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Nikitash Pawar on 7/23/2017.
 */
public class FirstNonRepeatingChar {

    public static void main(String[] args) {
        String input="nikitash";

        Character output = input.chars()
                .mapToObj(i -> Character.valueOf((char) i))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();

        System.out.println(output);

    }
}

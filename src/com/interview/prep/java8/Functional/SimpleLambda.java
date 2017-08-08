package com.interview.prep.java8.Functional;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Nikitash Pawar on 7/5/2017.
 */
public class SimpleLambda {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, (b,a)-> b.compareTo(a));

        System.out.println(names);

        Convert<Integer,String> converter= (from)->Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);


        converter= Integer::valueOf;
        converted = converter.convert("124");
        System.out.println(converted);

        Something something=new Something();
        Convert<String,String> converter1= something::startsWith;
        String converted1 = converter1.convert("Java");
        System.out.println(converted1);

    }
}

interface Convert<O,I>
{
    O convert(I input);
}

class Something {
    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}
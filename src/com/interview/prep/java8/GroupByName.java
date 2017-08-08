package com.interview.prep.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Nikitash Pawar on 7/5/2017.
 */
public class GroupByName {

    public static void main(String[] args) {

       /* List<Employee> entries=new ArrayList<>();
        entries.add(new Employee(0,"A","BAPI",10));
        entries.add(new Employee(1,"B","CCD",11));
        entries.add(new Employee(2,"C","WEB",12));
        entries.add(new Employee(3,"D","BAPI",13));
        entries.add(new Employee(4,"E","BAPI",14));
        entries.add(new Employee(5,"F","WEB",15));
        entries.add(new Employee(6,"G","CCD",16));


        Map<Employee, Long> collect = entries.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);*/


        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        items
                .stream()
                .filter(s->s.equalsIgnoreCase("apple"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);







    }
}

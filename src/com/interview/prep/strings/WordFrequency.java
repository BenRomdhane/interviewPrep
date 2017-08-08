package com.interview.prep.strings;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.summarizingInt;

/**
 * Created by Nikitash Pawar on 7/23/2017.
 */
public class WordFrequency {

    public static void main(String[] args) {

        List<String> keywords = Arrays.asList("Apple", "Ananas", "Mango", "Banana", "Beer", "Apple", "Mango",
                "Mango");

        Map<String, List<String>> collect = keywords.stream()
                .collect(Collectors.groupingBy(i -> i.toString()));
        System.out.println(collect);


        Map<String, Long> collect1 = keywords.stream()
                .collect(Collectors.groupingBy(Function.identity(), counting()));
        System.out.println(collect1);

        Map<String, IntSummaryStatistics> collect2 = keywords.stream()
                .collect(Collectors.groupingBy(Function.identity(), summarizingInt(e -> 1)));
        System.out.println(collect2);

        Map<String, Long> collect3 = keywords.stream()
                .collect(Collectors.groupingBy(e -> e, counting()));
        System.out.println(collect3);

        ConcurrentMap<String, Integer> collect4 = keywords.parallelStream()
                .collect(Collectors.toConcurrentMap(w -> w, w -> 1, Integer::sum));
        System.out.println(collect4);


        ConcurrentMap<String, Long> collect5 = keywords.parallelStream()
                .collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));
        System.out.println(collect5);

    }
}

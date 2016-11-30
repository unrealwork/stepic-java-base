package org.stepic.java.stream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by shmagrinskiy on 11/30/16.
 */
public class FilterText {
    public static void main(String[] args) {
        String alphaNumericPattern = "[^a-zа-яё0-9]+";
        Stream<String> stream = new BufferedReader(new InputStreamReader(System.in))
                .lines();
        stream
                .map(x -> x.toLowerCase())
                .map(x -> x.split(alphaNumericPattern))
                .flatMap(Arrays::stream)
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(Function.identity(), Collectors.counting()),
                        map -> map.entrySet().stream()
                                .sorted(Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue).reversed()
                                        .thenComparing(Map.Entry::getKey))
                                .map(Map.Entry::getKey)
                                .limit(11)
                                .collect(Collectors.toList())))
                .forEach(System.out::println);
    }
}

package com.ss.t5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class t3 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "", "bc", "efg", "abcd", "", "jkl");


        List<String> collect = strings.stream().sorted().distinct().limit(3).collect(Collectors.toList());
        System.out.println(collect);


    }
}

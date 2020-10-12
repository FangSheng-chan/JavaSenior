package com.ss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t2 {
    public static void main(String[] args) {

        Integer.valueOf(123);
        Integer[] num={1,23,5,3,12};
        List<Integer> ints = Arrays.asList(num);
        System.out.println(ints);



        System.out.println(num);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            list.add(num[i]);
        }
        System.out.println(list);
    }
}

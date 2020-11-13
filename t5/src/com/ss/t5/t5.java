package com.ss.t5;

import java.util.ArrayList;

public class t5 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(123);

        System.out.println(list.getClass() == integers.getClass());

        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = { "Hello", "World" };
        printArray( intArray  );
        printArray( stringArray  );

    }

    public static <E> void printArray(E[] inputArray){
        for (E e : inputArray) {
            System.out.printf("%s",e);
        }
        System.out.println();
    }

    public static <E> void printList(E[] inputList){

    }
}

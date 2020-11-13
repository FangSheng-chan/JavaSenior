package com.ss.java;


import org.junit.Test;


/**
 * String 不可变性
 */
public class StringMethodTest {
    @Test
    public void test1() {
        String s = "hello";
        char c = s.charAt(1);
        String s1 = s.toUpperCase();
        System.out.println(s1);
        System.out.println(s.charAt(0));
        System.out.println(s.isEmpty());
        System.out.println(s.charAt(1));
        String concat = s.concat(s1);
        System.out.println(concat);

    }

    @Test
    public void test2() {
        String s5 = "abc";
        String s6 = "abe";
        int i = s5.compareTo(s6);
        System.out.println(i);

        boolean v = s5.contains("v");
        System.out.println(v);

        int index = s6.indexOf("lol");
        System.out.println(index);
    }
}
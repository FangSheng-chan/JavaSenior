package com.ss.java;

import org.junit.Test;

public class StringTest01 {

    @Test
    public void test01(){
        String s1 = "123";
        int num = Integer.parseInt(s1);

        String s2 = String.valueOf(num);
        String s3 = num + "";

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

    }

}

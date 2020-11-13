package com.ss.t8;

import java.util.Date;

public class t2 {
    public static void main(String[] args) {
        Person person = new Person("dd");
        int i = person.hashCode();
        Person person1 = new Person("ss");
        int i1 = person1.hashCode();
        System.out.println(i1);
        System.out.println(i);
    }
}

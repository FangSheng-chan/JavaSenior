package com.ss;

public class t4 {
    public static void main(String[] args) {
            A a = new A();
            AA aa = new AA();
            AAA aaa = new AAA();
            System.out.println(a instanceof A);//true
            System.out.println(a instanceof AA);//false
            System.out.println(aa instanceof AAA);//false
            System.out.println(aaa instanceof A);//true
            System.out.println(aaa instanceof AA);//true
        }

    }
    class A {
    }

    class AA extends A {
    }

    class AAA extends AA {
    }

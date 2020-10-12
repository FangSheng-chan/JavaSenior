package com.ss;

public class t3 {

    static String ss = "ss";

    public void getName(){
        ss = "dd";
        System.out.println(ss);
    }

    public static void main(String[] args) {
        t3 t3 = new t3();
        t3.getName();
    }
}

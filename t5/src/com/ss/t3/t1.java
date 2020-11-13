package com.ss.t3;

import java.util.List;
import java.util.Vector;

public class t1 {
    public static void main(String[] args) {
        List<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(3);
        vector.add(5);
        vector.remove(2);
        System.out.println(vector);
    }
}

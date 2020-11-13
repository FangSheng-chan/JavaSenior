package com.ss.t3;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.LinkedList;

public class t2 {
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>();
        LinkedList<Integer> l2 = new LinkedList<>();

        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        l1.add(6);
        l1.add(7);
        Integer integer = l1.get(5);
        System.out.println(integer);

        l2.add(1);
        l2.add(2);
        l2.add(3);
        l2.add(4);
        l2.add(5);
        l2.add(6);
//        Integer poll = l2.poll();
//        System.out.println(poll);
//        Integer peek = l2.peek();
//        l2.offer(7);
        l2.offerLast(8);
        l2.offerFirst(5);
        System.out.println(l2);


    }
}

package com.ss.t5;

import java.time.LocalDateTime;
import java.util.*;

public class t2 {
    public static void main(String[] args) {
        LinkedList<String> linkedList;
        Stack<String> stack1;
        LinkedList<String> list;

        //Stack类实现时，push
        stack1 = new Stack<>();
        stack1.push("1");
        stack1.push("2");
        stack1.push("3");
        stack1.push("4");


        System.out.println(stack1);
        String pop = stack1.pop();
        System.out.println(pop);

        linkedList = new LinkedList<>();
        linkedList.push("1");
        linkedList.push("2");
        linkedList.push("3");
        linkedList.push("4");


        System.out.println(linkedList);

        String pop1 = linkedList.pop();
        System.out.println(pop1);

        String poll = linkedList.poll();
        System.out.println(poll);


        Queue<Object> objects = new LinkedList<>();
        objects.offer(1);
        objects.offer(2);
        objects.offer(3);
        objects.offer(4);


        System.out.println("obj" + objects);

        Object poll1 = objects.poll();
        System.out.println(poll1);
        System.out.println(objects);

        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        System.out.println(integers);

//        Integer pop2 = integers.pop();
//        System.out.println(pop2);
        Integer poll2 = integers.poll();
        System.out.println(poll2);


    }
}

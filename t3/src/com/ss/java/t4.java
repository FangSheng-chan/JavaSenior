package com.ss.java;

import java.util.Queue;

public class t4 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                pong();
            }
        };
        t.run();
        System.out.println("ping");
    }

    static void pong() {
        System.out.println("pong");
    }
}

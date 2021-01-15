package t5;

import java.util.*;
import java.util.concurrent.TimeUnit;


class Person {
    public void ss() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ss");

    }
}

public class t1 {
    public static void main(String[] args) {
        Person person = new Person();
        person.ss();
    }
}

package t4;

import java.util.ArrayList;
import java.util.List;

public class DeadLockDemo {
    private static List<Object> resource1 = new ArrayList<>();//资源 1
    private static Object resource2 = new Object();//资源 2

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    resource1.add(i);
                    System.out.println(resource1);

            }
        }, "线程 1").start();


        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource2");
            }
        }, "线程 2").start();
    }
}

package t6;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class test01 {



    static final String THREAD_SAVE_ORDER = "THREAD_SAVE_ORDER";
    static final String THREAD_SAVE_ADDR = "THREAD_SAVE_ADDR";

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "\t保存订单的线程");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, THREAD_SAVE_ORDER);

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "\t保存收货地址的线程");
            }
        }, THREAD_SAVE_ADDR);

        thread1.start();
        thread2.start();
    }
}

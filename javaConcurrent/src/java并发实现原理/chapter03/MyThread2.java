package java并发实现原理.chapter03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fangsheng
 * @date 2021/6/17 2:58 下午
 */
public class MyThread2 extends Thread {

    public static void main(String[] args) {
        try {
            t3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void t3() throws InterruptedException {
        final Lock lock = new ReentrantLock();
        lock.lock();
        Thread.sleep(1000);
        Thread t1 = new Thread(() -> {
//                lock.lock();
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "interrupted");
        });
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        Thread.sleep(100000000);
    }

}

package java并发编程之美.chapter6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockSupportDemo {

    static Object object = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + "\t" + "come in");
            LockSupport.park();
//            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t" + "被唤醒");
        });
        a.start();

        new Thread(() -> {
//            LockSupport.unpark(a);
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName() + "\t" + "通知");
        }).start();
    }

    private static void lockAwaitSignal() {
        new Thread(() -> {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "\t" + "come in");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "被唤醒");
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t" + "通知");
            } finally {
                lock.unlock();
            }
        }).start();
    }

    private static void synchronizedAwait() {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "\t" + "come in....");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "被唤醒...");
            }
        }).start();

        new Thread(() -> {
            synchronized (object) {
                object.notify();
                System.out.println(Thread.currentThread().getName() + "\t" + "通知");
            }
        }).start();
    }
}

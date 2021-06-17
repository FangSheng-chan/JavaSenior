package java并发实现原理.chapter03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fangsheng
 * @date 2021/6/16 3:46 下午
 */
public class ReenterLockDemo {
    public static void main(String[] args) {
        Iphone iphone = new Iphone();
        Thread t1 = new Thread(iphone, "t1");
        Thread t2 = new Thread(iphone, "t2");
        t1.start();
        t2.start();
    }
}

class Iphone implements Runnable {

    Lock lock = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    public void getLock() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t get Lock");
            setLock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void setLock() {
        lock2.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t set Lock");
        } finally {
            lock2.unlock();
        }
    }

    @Override
    public void run() {
        getLock();
    }
}

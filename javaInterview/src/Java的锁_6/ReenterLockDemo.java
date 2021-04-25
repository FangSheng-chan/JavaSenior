package Java的锁_6;

/**
 * 可重入锁就是递归锁
 * ReentrantLock/Synchronized 就是典型的可重入锁
 * <p>
 * 线程可以进入任何一个它已经拥有的锁所同步的代码块
 * <p>
 * 作用：避免死锁
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fangsheng
 * @date 2021/4/23 下午4:52
 */

class Phone implements Runnable {

    ReentrantLock lock = new ReentrantLock();

    /**
     * set 进去的时候，就加锁，调用set方法的时候，能否访问另外一个加锁的set方法
     */
    public void getLock() {
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t get lock");
            setLock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            lock.unlock();
        }
    }

    public void setLock() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t set lock");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void sendSMS() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "\t invoked sendSMS");
        sendEmail();
    }

    public synchronized void sendEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "\t invoked sendEmail");
    }

    @Override
    public void run() {
        getLock();
    }
}

public class ReenterLockDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();

        Thread t3 = new Thread(phone, "t3");
        Thread t4 = new Thread(phone, "t4");
        t3.start();
        t4.start();
    }
}



















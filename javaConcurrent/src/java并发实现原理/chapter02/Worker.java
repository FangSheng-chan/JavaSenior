package java并发实现原理.chapter02;

/**
 * @author fangsheng
 * @date 2021/6/10 4:58 下午
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Worker {
    private Object o = new Object();
    private ReentrantLock lock = new ReentrantLock();

    public void work1(String action) {
        System.out.println(action + " start");
        synchronized (o) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(action + " work");
        }
        System.out.println(action + " over");
    }

    public void work2(String action) {
        System.out.println(action + " start");
        if (lock.tryLock()) {
            System.out.println(action + " work");
        }
        System.out.println(action + " over");
    }

    public void work3(String action) {
        System.out.println(action + " start");
        try {
            lock.lockInterruptibly();
            lock.lock();
            System.out.println(action + " work");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println(action + " over");
    }
}


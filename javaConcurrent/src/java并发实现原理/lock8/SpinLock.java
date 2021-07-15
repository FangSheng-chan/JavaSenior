package java并发实现原理.lock8;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author fangsheng
 * @date 2021/7/7 3:16 下午
 */
public class SpinLock {

    private final AtomicReference<Thread> cas;

    public SpinLock(AtomicReference<Thread> cas) {
        this.cas = cas;
    }

    public void lock() {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName());
        while (!cas.compareAndSet(null, currentThread)) {
            System.out.println(currentThread.getName() + "i am spinning");
        }
    }

    public void unlock() {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName());
        cas.compareAndSet(currentThread, null);
    }
}

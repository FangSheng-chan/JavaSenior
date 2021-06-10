package java并发实现原理.chapter01;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * @author fangsheng
 * @date 2021/6/7 7:41 下午
 */
public class T11 {
    public static void main(String[] args) {
        LockSupport.park();
    }
}

class FIFOMutex {
    private final AtomicBoolean locked = new AtomicBoolean(false);
    private final Queue<Thread> waiters = new ConcurrentLinkedQueue<Thread>();

    public void lock() {
        boolean wasInterrupter = false;
        Thread currentThread = Thread.currentThread();
        waiters.add(currentThread);
        while (waiters.peek() != currentThread || !locked.compareAndSet(false, true)) {
            LockSupport.park(this);
            if (Thread.interrupted()) {
                wasInterrupter = true;
            }
        }
        waiters.remove();
        if (wasInterrupter) {
            currentThread.interrupt();
        }
    }

    public void unLock() {
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }
}

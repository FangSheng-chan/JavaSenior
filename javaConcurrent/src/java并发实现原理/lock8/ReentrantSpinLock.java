package java并发实现原理.lock8;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author fangsheng
 * @date 2021/7/7 4:05 下午
 */
public class ReentrantSpinLock {
    private final AtomicReference<Thread> cas;
    private int count;

    public ReentrantSpinLock(AtomicReference<Thread> cas) {
        this.cas = cas;
    }

    public void lock() {
        Thread current = Thread.currentThread();
        System.out.println(current.getName());
        // 如果当前线程已经获取到了锁，线程数增加一，然后返回
        if (current == cas.get()) {
            count++;
            //直接 return
            return;
        }
        // 如果没获取到锁，则通过CAS自旋
        while (!cas.compareAndSet(null, current)) {
            System.out.println(current.getName() + "\ti am spinning");
        }
    }

    public void unlock() {
        Thread cur = Thread.currentThread();
        if (cur == cas.get()) {
            // 如果大于0，表示当前线程多次获取了该锁，释放锁通过count减一来模拟
            if (count > 0) {
                count--;
                // 如果count==0，可以将锁释放，这样就能保证获取锁的次数与释放锁的次数是一致的了。
            } else {
                cas.compareAndSet(cur, null);
            }
        }
    }
}

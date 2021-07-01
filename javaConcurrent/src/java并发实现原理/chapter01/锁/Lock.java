package java并发实现原理.chapter01.锁;

/**
 * @author fangsheng
 * @date 2021/6/28 3:24 下午
 * <p>
 * 不可重入锁
 */
public class Lock {
    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}

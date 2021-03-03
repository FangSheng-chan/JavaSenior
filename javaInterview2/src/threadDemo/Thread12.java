package threadDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fangsheng
 * @date 2021/2/25 下午4:16
 */
public class Thread12 {

}

class Counter6 {
    private int count;

    public void add(int n) {
        synchronized (this) {
            count += n;
        }
    }
}

class Counter7 {
    private final Lock lock = new ReentrantLock();
    private int count;

    public void add(int n) {

        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)){

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.lock();
        try {
            count += n;
        } finally {
            lock.unlock();
        }
    }
}



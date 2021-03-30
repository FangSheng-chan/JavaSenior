package threadDemo3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * @author fangsheng
 * @date 2021/3/3 下午3:18
 */

class MyCache2 {
    private volatile Map<String, Object> map = new HashMap<>();
    private final StampedLock stampedLock = new StampedLock();

    public void put(String key, Object value) {
        long stamp = stampedLock.writeLock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);
            try {
                // 模拟网络拥堵，延迟0.3秒
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    public void get(String key) {
        long stamp = stampedLock.tryOptimisticRead();
        if (!stampedLock.validate(stamp)) {
            stamp = stampedLock.readLock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t 正在读取:");
                try {
                    // 模拟网络拥堵，延迟0.3秒
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Object value = map.get(key);
                System.out.println(Thread.currentThread().getName() + "\t 读取完成：" + value);
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }
    }
}

public class StampedLockDemo {
    public static void main(String[] args) {
        MyCache2 myCache = new MyCache2();
        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(tempInt + "", tempInt + "");
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.get(tempInt + "");
            }, String.valueOf(i)).start();
        }
    }
}

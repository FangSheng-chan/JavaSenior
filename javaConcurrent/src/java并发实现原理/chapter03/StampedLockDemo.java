package java并发实现原理.chapter03;

import java.util.concurrent.locks.StampedLock;

/**
 * @author fangsheng
 * @date 2021/6/18 3:53 下午
 */
public class StampedLockDemo {

    private int balance;

    private StampedLock lock = new StampedLock();

    public StampedLockDemo() {
        balance = 10;
    }

    public void conditionReadWrite(int value) {
        // 首先判断balance的值是否符合更新的条件
        long stamp = lock.readLock();
        while (balance > 0) {
            long writeStamp = lock.tryConvertToWriteLock(stamp);
            // 成功转换成为写锁
            if (writeStamp != 0) {
                stamp = writeStamp;
                balance += value;
                break;
            } else {
                // 没有转换成写锁，这里需要首先释放读锁，然后再拿到写锁
                lock.unlockRead(stamp);
                // 获取写锁
                stamp = lock.writeLock();
            }
        }
        lock.unlock(stamp);
    }

    public void optimisticRead() {
        long stamp = lock.tryOptimisticRead();
        int c = balance;
        // 这里可能会出现了写操作，因此要进行判断
        if (!lock.validate(stamp)) {
            // 要重新读取
            stamp = lock.readLock();
            try {
                c = balance;
            } finally {
                lock.unlockRead(stamp);
            }
        }
        System.out.println("读取的值为:" + c);
    }

    public void read() {
        long stamp = lock.readLock();
        lock.tryOptimisticRead();
        int c = balance;
        System.out.println("读取的值为:" + c);
        // ...
        lock.unlockRead(stamp);
    }

    public void write(int value) {
        long stamp = lock.writeLock();
        balance += value;
        lock.unlockWrite(stamp);
    }

    public static void main(String[] args) {
        StampedLockDemo demo = new StampedLockDemo();
        new Thread(() -> {
            while (true) {
                demo.read();
                demo.optimisticRead();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                demo.write(2);
                demo.conditionReadWrite(3);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}

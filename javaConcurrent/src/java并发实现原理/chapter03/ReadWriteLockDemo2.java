package java并发实现原理.chapter03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author fangsheng
 * @date 2021/6/16 7:15 下午
 */
public class ReadWriteLockDemo2 {
    public static void main(String[] args) {
        MyCache2 myCache = new MyCache2();
        // 线程操作资源类，5个线程写
        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(tempInt + "", tempInt + "");
            }, String.valueOf(i)).start();
        }
        // 线程操作资源类， 5个线程读
        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.get(tempInt + "");
            }, String.valueOf(i)).start();
        }
    }
}
class MyCache2 {
    private volatile Map<String, Object> map = new HashMap<>();

    private ReentrantLock rwLock = new ReentrantLock();
    private ReentrantLock rwLock2= new ReentrantLock();

    public void put(String key, Object value) {
        rwLock.lock();
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
            // 写锁 释放
            rwLock.unlock();
        }
    }

    public void get(String key) {
        rwLock.lock();
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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 读锁释放
            rwLock.unlock();
        }
    }
}
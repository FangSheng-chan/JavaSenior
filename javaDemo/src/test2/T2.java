package test2;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author fangsheng
 * @date 2021/3/1 下午4:29
 */
public class T2 {
    public static void main(String[] args) {
        int[] ints = new int[10];
        ints[1] = ints[1] + 1;
        int[] ints1 = Arrays.copyOf(ints, ints.length);
        for (int anInt : ints1) {
            System.out.println(anInt);
        }
    }
}

class Counter {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock rLock = readWriteLock.readLock();
    private final Lock wLock = readWriteLock.writeLock();
    private int[] counts = new int[10];


    public void inc(int index) {
        wLock.lock(); // 加写锁
        try {
            counts[index] += 1;
        } finally {
            wLock.unlock(); // 释放写锁
        }
    }

    public int[] get() {
        rLock.lock(); // 加读锁
        try {
            int[] ints = Arrays.copyOf(counts, counts.length);
            return ints;
        } finally {
            rLock.unlock(); // 释放读锁
        }
    }
}

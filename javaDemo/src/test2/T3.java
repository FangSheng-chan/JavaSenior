package test2;

import apple.laf.JRSUIUtils;

import java.util.concurrent.locks.StampedLock;

/**
 * @author fangsheng
 * @date 2021/3/1 下午4:43
 */
public class T3 {
    public static void main(String[] args) {
        Point point = new Point();
        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
                point.move(Math.random()*100,Math.random()*100);
            },String.valueOf(i)).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName());
                System.out.println(point.distance());
            },String.valueOf(i)).start();
        }
    }
}

class Point {

    private final StampedLock stampedLock = new StampedLock();

    private double x;
    private double y;

    public void move(double deltaX, double deltaY) {
        long stamp = stampedLock.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    public double distance() {
        long stamp = stampedLock.tryOptimisticRead();
        double currentX = x;
        double currentY = y;
        if (!stampedLock.validate(stamp)) {
            stamp = stampedLock.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}
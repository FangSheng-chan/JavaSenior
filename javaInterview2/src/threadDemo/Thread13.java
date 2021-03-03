package threadDemo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fangsheng
 * @date 2021/2/26 下午4:00
 */
public class Thread13 {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    String s = "2";
                    System.out.println("123");
                    task.add1(s);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            });
            thread.start();
            thread.join();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(task.add2());
                }
            }).start();
        }
    }
}

class Task {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<String> queue = new LinkedList<>();

    public void add1(String s) {
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String add2() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return queue.remove();
    }
}

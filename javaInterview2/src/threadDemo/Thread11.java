package threadDemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fangsheng
 * @date 2021/2/25 下午3:25
 */
public class Thread11 {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue taskQueue = new TaskQueue();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    // 执行 task
                    while (true) {
                        try {
                            String task = taskQueue.getTask();
                            System.out.println("execute task：" + task);
                        } catch (Exception e) {
                            return;
                        }
                    }
                }
            };
            thread.start();
            threads.add(thread);
        }

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // 放入 task
                String s = "t---------" + Math.random();
                System.out.println("add task：" + s);
                taskQueue.addTask(s);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
            }
        }, "A");
        thread.start();
        thread.join();
        Thread.sleep(3000);
        for (Thread thread1 : threads) {
            thread1.interrupt();
        }
    }
}

class TaskQueue {

    Queue<String> queue = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        // 唤醒在this锁等待的线程
        this.notifyAll();
    }

    public synchronized String getTask() {
        while (queue.isEmpty()) {
            try {
                // 当一个线程在this.wait()等待时，它就会释放this锁，从而使得其他线程能够在addTask()方法获得this锁。
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String remove = queue.remove();
        return remove;
    }
}

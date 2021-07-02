package java并发实现原理.chapter05;

import java.sql.Time;
import java.util.concurrent.*;

/**
 * @author fangsheng
 * @date 2021/6/21 4:17 下午
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        TestArrayBlockingQueue();
    }

    private static void TestSynchronousQueue() {
        /**
         * 一存一取的状态¬
         */
        SynchronousQueue<Object> synchronousQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t put A ");
                synchronousQueue.put("A");
                System.out.println(Thread.currentThread().getName() + "\t put B ");
                synchronousQueue.put("B");
                System.out.println(Thread.currentThread().getName() + "\t put C ");
                synchronousQueue.put("C");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                synchronousQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t take A ");

                TimeUnit.SECONDS.sleep(2);
                synchronousQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t take B ");

                TimeUnit.SECONDS.sleep(2);
                synchronousQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t take C ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void TestLinkedBlockingQueue() {
        LinkedBlockingQueue<Object> linkedBlockingQueue = new LinkedBlockingQueue<>();
        try {
            linkedBlockingQueue.offer(1, 2L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void TestArrayBlockingQueue() {
        BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        try {
            blockingQueue.offer(1, 1, TimeUnit.SECONDS);
            blockingQueue.offer(1, 1, TimeUnit.SECONDS);
            System.out.println(blockingQueue.offer(1, 1, TimeUnit.SECONDS));
            System.out.println(blockingQueue.offer(1, 1, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
